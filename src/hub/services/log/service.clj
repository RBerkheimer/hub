(ns hub.services.log.service
    (:require [clojure.core.async :as async]
              [hub.services.message.service :refer [publisher publication]])
    (:gen-class))


(def subscriber (async/chan))
(def subscription (async/sub publication :log subscriber))

(defn log [message]
    "adds a message to an output log file"
    (let [{:keys [id topic timestamp content]} message]
        (println id topic timestamp content)))

(defn logger []
    (async/go-loop []
        (let [message (async/<! subscriber)]
            (log message)
            (recur))))

(println "subscription: " subscription)
