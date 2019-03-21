(ns hub.services.log.service
    (:require [clojure.core.async :as async]
              [clojure.java.io :as io]
              [hub.services.message.service :refer [publisher publication]])
    (:gen-class))


(def subscriber (async/chan))
(def subscription (async/sub publication :log subscriber))
(def logfile (str (io/resource "logging/messages.txt")))

(defn log [message]
    "Adds a message to an output log file (specified by logfile def above)"
    (let [{:keys [id topic timestamp content]} message]
        (spit logfile (apply str id "," timestamp "," topic "," content "\n") :append true)))

(defn add-headers []
    (spit logfile "id,timestamp,topic,content\n"))

(defn init-logfile []
    (let [contents (slurp logfile)]
        (if (= contents "") (add-headers))))

(defn logger []
    "uses a go(loop) to look for messages on the logging subscription.
    Parks when no messages are coming through (not really running all the time)."
    (async/go-loop []
        (let [message (async/<! subscriber)]
            (log message)
            (recur))))

(defn init []
    (logger)
    (init-logfile))
