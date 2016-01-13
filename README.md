CivMonitor
=============

Simple monitor server for sharded servers.

First draft just pushes to a file or DB.

Second draft targets to host a simple JSON query service for active monitoring.

Data monitored:

* TPS
* Player Count
* Latency to fixed hostlist (configured)
* Player Ping Statistics (min, avg, max)
* Player Churn (connections since last check, disconnects)
* Free Space on disk
