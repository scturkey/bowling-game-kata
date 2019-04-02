# Bowling Game Kata

[bowling-score]: http://www.wpclipart.com/recreation/sports/bowling/bowling_scoresheet_example.png "bowling score card"

The game consists of 10 frames as shown above. In each frame the player has two opportunities to knock down 10 pins. The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two tries. The bonus for that frame is the number of pins knocked down by the next roll. So in frame 3 above, the score is 10 (the total number knocked down) plus a bonus of 5 (the number of pins knocked down on the next roll.)

A strike is when the player knocks down all 10 pins on his first try. The bonus for that frame is the value of the next two balls rolled.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in tenth frame.

![Bowling Game](bowling-game.png)

## Algorithm
* Game
    * contains 10 Frames. Each 9 frame...
        * 10 pin
        * Roll 1
            * knockedDownPins of Roll1 == 10 ? Strike
        * Roll 2
            * knockedDownPins of Roll1 + knockedDownPins of Roll2 == 10 ? Spare
        * total points = knockedDownPins of Roll1 + knockedDownPins of Roll2
            * if (total points < 10) finalize(frame of roll(n))
        * Calculate bonuses
            * if (roll(n-2) == strike) roll(n-2).point + roll(n).point and finalize(frame of roll(n-2))
            * if (roll(n-1) == strike) roll(n-2).point + roll(n).point
            * if (roll(n-1) == spare)  roll(n-1).point + roll(n).point and finalize(frame of roll(n-1))
    * for Last Frame
        * if (roll19 == strike || roll20 == strike || roll20 == spare) roll 3 times in this frame
