;
; Copyright © 2013,2014 Peter Monks (pmonks@gmail.com)
;
; Licensed under the Apache License, Version 2.0 (the "License");
; you may not use this file except in compliance with the License.
; You may obtain a copy of the License at
; 
;     http://www.apache.org/licenses/LICENSE-2.0
; 
; Unless required by applicable law or agreed to in writing, software
; distributed under the License is distributed on an "AS IS" BASIS,
; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
; See the License for the specific language governing permissions and
; limitations under the License.
; 
; This file is part of an unsupported extension to Alfresco.
;

(defproject alfresco-technical-validation "0.1.0-SNAPSHOT"
  :description      "Performs technical validation of an Alfresco extension."
  :url              "https://github.com/pmonks/depends"
  :license          {:name "Apache License, Version 2.0"
                     :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :min-lein-version "2.0.0"
  :javac-target     "1.7"
  :dependencies [
                  [org.clojure/clojure                "1.6.0"]
                  [org.clojure/tools.cli              "0.3.1"]
                  [org.clojure/tools.logging          "0.2.6"]
                  [clojurewerkz/neocons               "2.0.1"]
                  [ch.qos.logback/logback-classic     "1.1.2"]
                  [me.raynes/conch                    "0.6.0"]
                  [io.aviso/pretty                    "0.1.10"]
                  [org.clojars.pmonks/depends         "0.2.0"]
                  [org.clojars.pmonks/multigrep       "0.1.0"]
                  [org.clojars.pmonks/bookmark-writer "0.1.0"]
                ]
  :profiles {:dev {:dependencies [
                                   [midje          "1.6.3"]
                                   [clj-ns-browser "1.3.1"]
                                 ]
                   :plugins      [[lein-midje "3.1.1"]]}   ; Don't remove this or travis-ci will assplode!
             :uberjar {:aot :all}}
  :uberjar-merge-with {#"META-INF/services/.*" [slurp str spit]}   ; Awaiting Leiningen 2.3.5 - see https://github.com/technomancy/leiningen/issues/1455
  :main alfresco-technical-validation.main
  :bin {:name "atv"})
