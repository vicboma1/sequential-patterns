Double Buffer
=============

 A buffered class encapsulates a buffer: a piece of state that can be modified.
 To do this, the class keeps two instances of the buffer: a next buffer and a current buffer.

 When information is read from a buffer, it is always from the current buffer. 
 When information is written to a buffer, it occurs on the next buffer. 
 When the changes are complete, a swap operation swaps the next and current buffers instantly so that the new buffer is 
 now publicly visible. The old current buffer is now available to be reused as the new next buffer.
 
 Others examples
 ``` 
 Based on buffer pool images:
 https://github.com/victorakamon/emulators/blob/master/chip8/src/emulator/specification/graphics/BufferPoolImage.java
 ```
 
