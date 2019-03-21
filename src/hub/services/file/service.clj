(ns hub.services.file.service
    (:require [clojure.core.async :as async]
              [hub.services.message.service :refer [publication]]
              [hub.utils.service-utils :refer [startup]])
    (:gen-class))

(def subscriber (async/chan))
(def subscription (async/sub publication :file subscriber))

(defn parse-file [message]
    "Reads a message and parses some data."
    (let []
    (println "file message: " message)))

(defn init []
    (println "starting file service")
    (startup subscriber parse-file))
