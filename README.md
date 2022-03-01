# Battle Simulator

This project is a simple battle simulator in which I will try getting a grasp of vectors (advanced and basic)
as well as working with java streams.

In the end this should be a game you can play in singleplayer using a javafx view. There should be a basic pathfinding
AI as well as the possibility for the player to control their own team.

## Base Concept

| Name   | Description                                                                                               |
|--------|:----------------------------------------------------------------------------------------------------------|
| Field  | A Field contains a list of Elements and Teams. These elements can block the was of the units in the Teams |
| Team   | A Team is a group of Units                                                                                |
| Player | A Player controls the logic of a Unit. They may be computer controlled or by human input                  |
| Unit   | The representation of a single fighter without any thought logic                                          |

The field should be displayed as a bitmap on the GUI with each Unit being a pixel having the color of their Team.

Example to start the tool:
- `java BattleSim 10 10 russia=1s,2a,3c ukrain=3s,2a`



This is composed of the size of the field as the first 2 params. Followed by a Team; Here the name and the content is
split using the '=' char. In the content first the [Unit Types](#unit-types) as their char are set followed by the
amount of said type to be found. If more than one type os unit is wanted they have to be seperated by a ',' (comma)

## Unit Types

| Letter | Description                                   |
|--------|:----------------------------------------------|
| s      | A simple gun fighter with heightened range    |
| c      | A fighter for short range that is pretty fast |
| a      | A basic gun fighter (using an AK45)           |
|        |                                               |
|        |                                               |

The letters are to be used in the start params