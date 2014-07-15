Time Step with Variable in Game Loop
==================
 The alternative to a fixed time step is a variable time step, where as soon as the update and draw stages of the
 game loop are complete, the next one starts immediately. The waiting stage is bypassed. 
 This happens regardless of whether the game is running fast or slow. 
 As such, with a variable time step, there's no such thing as running slowly.

* Advantages
  * ```Smooth```
  * ```Easier to code```
  * ```Delta time between each update to vary the movement of objects```
  
* Disadvantages
  * ```Hard to record actions```
  * ```Physics are not predictable```
  
  

Others examples:
```
https://github.com/victorakamon/emulators/blob/master/chip8/src/core/Processor.java
```