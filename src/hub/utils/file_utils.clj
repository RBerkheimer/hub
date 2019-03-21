(ns hub.utils.file-utils
    (:require [clojure.java.io :as io])
    (:gen-class))


(def input-files [(io/resource "inputs/1E3SalesRecords.csv")])
