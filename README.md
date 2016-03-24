# Universe
**Simulation of the Universe**
## The modifications made
####Added radius for each star. 
1. *Line: 23, 50, 142*[Body](https://github.com/STOzaki/Universe/blob/master/src/nbody/Body.java)
2. *Line: 67, 76*[Universe](https://github.com/STOzaki/Universe/blob/master/src/nbody/Universe.java)

####Added color for each star.
1. *Line: 24, 51, 164* [Body](https://github.com/STOzaki/Universe/blob/master/src/nbody/Body.java)

#######Needed to import Color*(Line 4)* [Body](https://github.com/STOzaki/Universe/blob/master/src/nbody/Body.java)

2. This is before they combined to make the color.
  *Line: 68 - 71, 76*[Universe](https://github.com/STOzaki/Universe/blob/master/src/nbody/Universe.java)

####Added a tail.
*Line: 27, 72, 85 - 91, 141 - 152, 166* [Body](https://github.com/STOzaki/Universe/blob/master/src/nbody/Body.java)

####Added a title. *(which can be set in the text file).*
1. *Line: 26, 46, 53, 163* [Body](https://github.com/STOzaki/Universe/blob/master/src/nbody/Body.java)
2. *Line: 29, 54, 76* [Universe](https://github.com/STOzaki/Universe/blob/master/src/nbody/Universe.java)

####Added a way to create the length of the tail. *(which can be set in the text file).*
1. *Line: 29, 46, 54, 88* [Body](https://github.com/STOzaki/Universe/blob/master/src/nbody/Body.java)
2. *Line: 31, 55, 76* [Universe](https://github.com/STOzaki/Universe/blob/master/src/nbody/Universe.java)

####Added a way to modify the diminishing rate of the tail. *(it can be changed in the text file).*
1. *Line: 30, 46, 55, 145* [Body](https://github.com/STOzaki/Universe/blob/master/src/nbody/Body.java)
2. *Line: 32, 56, 76* [Universe](https://github.com/STOzaki/Universe/blob/master/src/nbody/Universe.java)

####Added code to make the balls bounce off the walls. *(Made new classes for it)*.
1. *Line: 118 - 133* [Body] (https://github.com/STOzaki/Universe/blob/master/src/nbody/Body.java)
2. *Line: 110* [Universe] (https://github.com/STOzaki/Universe/blob/master/src/nbody/Universe.java)
3. The bouncing method: *Line: 133 - 135, 143 - 145* [Vector](https://github.com/STOzaki/Universe/blob/master/src/nbody/Vector.java)

####Finished adding java doc code in the classes.
