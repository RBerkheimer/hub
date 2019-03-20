(ns hub.core
    (:require   [hub.services.service :as svc]
                [hub.services.message.service :refer [publish]])
  (:gen-class))

(defn -main
  "Run the system during prototyping."
  [& args]
  (let [m1 {:topic :log :content {:key1 "val1"}}]
  (publish (:topic m1) (:content m1))
  (println "Complete!")))
