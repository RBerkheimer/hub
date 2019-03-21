(ns hub.core
    (:require   [hub.web.server :as server]
                [hub.services.service :as svc])
  (:gen-class))

(defn -main
  "Bootstrap system as a web server and expose endpoints for submission of data."
  [& args]
  (server/run))

  ;(let [m1 {:topic :log :content {:key1 "val1"}}]
  ;(publish (:topic m1) (:content m1))
  ;(println "Complete!")))
