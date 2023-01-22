I have a bone to pick with spotfiy for an issue with their queue fuction that doesnt seem to apply to apple music. i was in the car
with a friend who recently transfered her music from apple to spotify. she is still getting used to the queue function in spotfiy 
so i queued some songs while she was driving. she came across a song she liked but skipped past it with the skip function on her steering 
wheel >>
"oops"
she then tried to go back by hitting the back button << 
this is a normal function for any playlist, and doesnt apply to the apple music queue that she was used to. imagine her surprise to not get
the song she accidentaly skipped but instead the first song from the queue. 
"what the hell? what happed to the songs before"
the answer is simple. they are gone. they are null. those spots do not exist. this is something i hadn't put much thought into until 
i was in the car with her. this is a very simple bug that could easily be fixed by maintiaing the queue in a linked list/arraylist that 
instead of remvoing an already played song and bumping up the songs in the queue 1 position, it keeps the songs in its list and traverses
the list fully, until the queue is ended or the session is cancelled, ie: logging out of the app. 

previous Linked list of Queue. 

|        |       |         |
| song A | ----->|  song B |
|        |       |         |
_____^________________________

becomes this when song A is done 

|        |     
| song B |
|        | 
_____^__________


Marys implementation 

|        |       |         |
| song A | ----->|  song B |
|        |       |         |
_____^________________________



|        |       |         |
| song A | ----->|  song B |
|        |       |         |
_______________________^______
