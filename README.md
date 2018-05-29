# BRB - Boredom Removal Bowling

This is an implementation of a 10-pin bowling game. 
This is a single-player game with a console-based UI, so nothing fancy visually right now but yeah, you would enjoy it nevertheless.
A user starts the game and with an enter-key based navigation control progresses to the next tosses. If he likes, he can keep playing more games.
An enhanced version with a cool UI coming pretty soon!

Rules
-----
1 game - 10 rounds
1 round - (For the first 9 rounds)1 toss if the first toss is a STRIKE, 2 tosses otherwise; (10th round)3 tosses if either the first toss is a STRIKE or if the round is a SPARE, 2 tosses otherwise
1 toss - Can score minimum 0 and maximum 10 points (Here score refers to the number of pins dislodged)
STRIKE - A round is a STRIKE if all 10 pins are dislodged in the first toss of the round
SPARE - A round is a SPARE if all 10 pins are dislodged first and second tosses of the round combined
GUTTER - If a toss dislodges 0 pins
PERFECT SCORE - 300, If all 12 assigned tosses lead to STRIKE
------

