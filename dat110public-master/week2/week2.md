## DAT110: Distributed Systems and Network Technology

### Lab Week 2: 14/01 - 18/01

** REMEMBER to do the end of week 1 quiz. **

#### Exercise 1 - Threads

Distributed and networked applications involve implementing exchange of message between processes that runs on different computers. In many cases, however, implementation of the application of a distributed system also involves writing multi-threaded applications where threads synchronise and communicate using shared memory. This is for instance the case when implementing multi-threaded servers and when implementing sending and reception of messages in communication protocols.

The main purpose of this exercise is to briefly recap inter-thread communication and synchronisation in Java before starting on network programming next week. The exercise uses the API for concurrent programming in Java https://docs.oracle.com/javase/tutorial/essential/concurrency/

We consider a small (emulated) IoT system consisting of a temperature sensor device and a display device. The sensor device and the display device runs as individual threads where the sensor-thread with periodic intervals reads the current temperature and the display-threads periodically display the current temperature.

##### 1.1

Clone the code base for the system from the github repository: https://github.com/selabhvl/dat110public.git

##### 1.2

Study the implementation of the  [`TemperatureDevice`](https://github.com/selabhvl/dat110public/blob/master/week2/iotthreads/src/no/hvl/dat110/threading/TemperatureDevice.java), [`DisplayDevice`](https://github.com/selabhvl/dat110public/blob/master/week2/iotthreads/src/no/hvl/dat110/threading/DisplayDevice.java), [`IoTSystem`](https://github.com/selabhvl/dat110public/blob/master/week2/iotthreads/src/no/hvl/dat110/threading/IoTSystem.java), [`TemperaturSensor`](https://github.com/selabhvl/dat110public/blob/master/week2/iotthreads/src/no/hvl/dat110/threading/TemperatureSensor.java), and [`TemperatureMeasurement`](https://github.com/selabhvl/dat110public/blob/master/week2/iotthreads/src/no/hvl/dat110/threading/TemperatureMeasurement.java). How does the sensor-thread and the display-thread exchange temperature?

##### 1.3

Augment the IoT system such that multiple display-threads are created each displaying the current temperature.

##### 1.4

Modify the IoT system from such that multiple temperature devices (threads) can update the temperature measurement. Make sure that only one of them is doing it at a time (hint: what does the modified [`synchronised`](https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html) do in java?)

##### 1.5

Modify the IoT system from item 1.2. such that instead of using a [`sleep()`](https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html) in the display-thread, then [`wait and notify`](https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html) are used such that the sensor-threads wakeup the display-thread when a new temperature has been reported.

#### Exercise 2 - Wireshark

Do the first Wireshark lab described at http://www-net.cs.umass.edu/wireshark-labs/Wireshark_Intro_v7.0.pdf

#### Exercise 3 - Communication Protocols

Problem P1 in Chap. 1 of Kurose and Ross.

#### Exercise 4 - Communication Metrics

Problems P6 and P10 in Chap. 1 of Kurose and Ross.
