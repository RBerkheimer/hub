(defproject hub "0.1.0-SNAPSHOT"
  :description "hub - kappa style file etl"
  :url "http://www.clojure.com"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                  [org.clojure/core.async "0.4.490"]
                  [clj-time "0.15.0"]]
  :main ^:skip-aot hub.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
