Miners have two behaviors, based on their hunger that strikes randomly.  When hungry, miners head straight to the
Mess House on the left side of the screen.  Otherwise, they head straight for a random point in the field, and
when they get within a certain distance of it, turn right and start circling that point. Use the Strategy
pattern to encapsulate these behaviors and eliminate the associated control coupling and logical cohesion.

Draw a UML class diagram.  Draw the MessHouse, Miner, and Thing classes, with the IS-A relationships between
them.  Do not draw any of the existing fields in the MessHouse class, but draw the Thing class's center
field and the Miner class's isHungry:boolean, target:MessHouse, and circleCenter:Point2D fields.  
Also draw the Miner class's setHunger() and step() methods.  Do not write other parts of the code into your
diagram unless you feel they are essential to illustrating your pattern work.

Then, do not redraw your diagram. Instead edit it by adding all classes, fields, and methods that are needed
for the Strategy pattern, crossing out or erasing anything that you remove while implementing the pattern.

Include only new methods, fields, and classes that you add for the strategy pattern. Also include all types,
all access modifiers, directed associations, names on associations where not implied, multiplicities other than 1.
Include fields even where implied by an association. Include IS-A relationships. Write "italics" and draw an
arrow towards items in italics.

When you get to the coding part, it should work without modification. Contact me immediately if it does not run.
Edit the program to illustrate the strategy pattern shown in your UML diagram. Update your diagram to show any
critical changes you make while coding.

Note that, as with all control-coupled to strategy-pattern conversions, you will need to replace both the places
where the control codes are _set_ and the places where the control codes are _read_ to control a switch/if-else block.

Push your code and get me to check off your UML diagram -- no need to turn it in.
