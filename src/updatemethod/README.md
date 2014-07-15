Update Method
================

 The game world maintains a collection of objects. Each object implements an update method that simulates 
 one frame of the object’s behavior. 
 Each frame, the game updates every object in the collection.
 
 * Work well when:
   
   Your game has a number of objects or systems that need to run simultaneously.
   Each object’s behavior is mostly independent of the others.
   The objects need to be simulated over time.

 Reference :  Bob Nystrom

Others examples:
```
https://github.com/victorakamon/emulators/blob/master/chip8/src/core/Processor.java
````
