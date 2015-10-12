Sequential-patterns
==================

[![Coverage Status](https://coveralls.io/repos/vicboma1/sequential-patterns/badge.svg?branch=master&service=github)](https://coveralls.io/github/vicboma1/sequential-patterns?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.eluder.coveralls/coveralls-maven-plugin/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.eluder.coveralls/coveralls-maven-plugin/)
[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/vicboma1/sequential-patterns/trend.png)](https://bitdeli.com/free "Bitdeli Badge")
[![Analytics](https://ga-beacon.appspot.com/UA-68658653-1/sequential-patterns/readme)](https://github.com/igrigorik/ga-beacon)

* [Game Loop](https://github.com/victorakamon/sequential-patterns/tree/master/src/gameloop) / [Test](https://github.com/victorakamon/sequential-patterns/blob/master/test/gameloop)
  * Classic
  ```
  The problem with it is you have no control over how fast time the game runs.
  
* If you have a bad machine, the game will not working...
* If you load a part of the game where there are heavy content (IA/Physics/Resources...), you will play slower.
* If you have a fast machine, the acts will be too fast..
```

  * Classic with Fixed Time Step
  ```
  Using a constant game speed with a maximum FPS is a solution that is easy to implement and keeps the game code simple. 

But there are still some problems: 

* Defining a high FPS can still pose problems on slow hardware (but not as severe as the first solution),
  and defining a low FPS will waste visual appeal on fast hardware.
```

  * Variable Time Step
  ```
  The alternative to a fixed time step is a variable time step, where as soon as the update and draw stages of the
 game loop are complete, the next one starts immediately. The waiting stage is bypassed. 
 This happens regardless of whether the game is running fast or slow. 
 As such, with a variable time step, there's no such thing as running slowly.

 Advantages
  * Smooth
  * Easier to code
  * Delta time between each update to vary the movement of objects
  
 Disadvantages
  * Hard to record actions
  * Physics are not predictable
  ```
  
  
* [Double Buffer](https://github.com/victorakamon/sequential-patterns/tree/master/src/doublebuffer) / [Test](https://github.com/victorakamon/sequential-patterns/blob/master/test/doublebuffer)
  * Buffer pool images 
   
  ``` 
  A buffered class encapsulates a buffer: a piece of state that can be modified.
 To do this, the class keeps two instances of the buffer: a next buffer and a current buffer.

 When information is read from a buffer, it is always from the current buffer. 
 When information is written to a buffer, it occurs on the next buffer. 
 When the changes are complete, a swap operation swaps the next and current buffers instantly so that the new buffer  is now publicly visible. The old current buffer is now available to be reused as the new next buffer.

 ```
 

* [Update Method](https://github.com/victorakamon/sequential-patterns/tree/master/src/updatemethod)
 ```
 The game world maintains a collection of objects. Each object implements an update method that simulates 
 one frame of the object’s behavior.  Each frame, the game updates every object in the collection.
 ```
* Work well when:
 ```  
 Your game has a number of objects or systems that need to run simultaneously.
 Each object’s behavior is mostly independent of the others.
 The objects need to be simulated over time.
 ```
   
 References:
  * http://www.java-gaming.org/index.php?topic=24220.0
  * http://entropyinteractive.com/2011/02/game-engine-design-the-game-loop/  
  * http://stackoverflow.com/questions/18283199/java-main-game-loop
  * http://notatkiprogramisty.blox.pl/2014/04/Programowanie-Gier-glowna-petla-gry-ang-game-loop.html
  * Glenn Fiedler - http://gafferongames.com/game-physics/fix-your-timestep/
  * Kevin Glass - http://www.cokeandcode.com/info/showsrc/showsrc.php?src=../spaceinvaders102/org/newdawn/spaceinvaders/Game.java
  * L. Spiro - http://lspiroengine.com/?p=378
  
