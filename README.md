# hub-engine-core
## clj.1.0.0

*Hub* is a polyglot backend *data* processing system designed for distributed computations of generic tasks. Although it sounds like it, hub isn't really a WMS, because it is topologically much larger than a WMS, consisting of a WMS type processing engine, a controller ring that distributes jobs, a distributed logging system that records state, and various processing endpoints that use different libraries and technologies.

Hub is an evolutionary 'best tool for the job' system, where languages and tools are fungible and decoupled from the system component they implement. The most important thing about hub components is intercommunication, which is managed by a strict and technology-agnostic message ontology. Components can have multiple iterations and multiple versions comprised of vastly different implementation detail.

*hub-engines* are the processing units of hub. Hub-engines consist of a hub-engine-core and one or more hub-engine-libraries.

This repository contains a version of hub-engine-core that is written in clojure, to take advantage of a few features of clojure that make it attractive as a processing core - namely, immutable state, core.async's pub-sub feature, and seamless JVM/GraalVM integration. Hub-engine-cores are decoupled from Hub-engine-libraries - so the only libraries included in this core are test libraries that validate various behaviors of the core itself. In practice, this core would be combined with libraries, and given a unique name in its systemic universe. This combination would serve as a flavor of a hub-engine, that could then be used in the greater context of hub processing.

To expound on and further illustrate this idea - if we compile hub-engine natively, put it in a container, and manage using an orchestrator, we have a distributed constellation of extremely small and fast processing units that spin up quickly, perform directed processing, compose their own immutable log of actions, and die with a final emission of that log to a distributed messaging system that can do something else with that information.


## Installation

Download from https://github.com/RBerkheimer/hub.

## Usage

Currently we are implementing tests in the core. Once complete we'll provide a build method that compiles this system using GraalVM and packages into a deployable container. 

    $ java -jar hub-0.1.0-standalone.jar


## Examples

...

### Bugs

...

## License

Copyright © 2019 Zeus Volkov Systems

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
