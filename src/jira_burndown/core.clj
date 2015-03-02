(ns jira-burndown.core
  (:require [clj-http.client :as client]
            [environ.core :refer [env]]))


(def host (env :jira-host))
(def base-url (str "https://" host))
(def creds [(env :jira-username) (env :jira-password)])


(def cfg {:throw-exceptions false
          :as               :json
          :basic-auth       creds})


(defn get-active-sprints
  [rapid-view-id]
  (let [response (client/get (str base-url "/rest/greenhopper/1.0/sprintquery/" rapid-view-id) cfg)
        sprints  (get-in response [:body :sprints])]
    (filter #(= (:state %) "ACTIVE") sprints)))


(defn get-sprint-ids
  [sprints]
  (map :id sprints))


(defn get-burndown
  (client/get (str base-url "/rest/greenhopper/1.0/rapid/charts/releaseburndownchart?rapidViewId=3&versionId=10100") cfg))