(ns hub.services.message.service
    (:require [clojure.core.async :as async]
              [clj-time.core :as time])
    (:gen-class))

;the central message publisher which other services should use to route all messages
(def publisher (async/chan))
;the multicast publisher for the central publisher, broadcasts on topic key
(def publication (async/pub publisher :topic))

(defn prepare [topic content]
    { :id (.toString (java.util.UUID/randomUUID))
      :timestamp (time/now)
      :topic (keyword topic)
      :content content})

(defn publish [topic content]
    "Prepares and publishes a message in the central publisher"
    (let [message (prepare topic content)]
        ;(async/go (async/>! publisher message))))
        (async/put! publisher message)))

(println "publication: " publication)
