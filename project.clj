(defproject jira-burndown "0.1.0-SNAPSHOT"

  :description "Tool to extract JIRA Agile's burndown chart"

  :url "https://github.com/conan/jira-burndown"

  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[cheshire "5.4.0"]
                 [clj-http "1.0.1"]
                 [environ "1.0.0"]
                 [org.clojure/clojure "1.6.0"]])
