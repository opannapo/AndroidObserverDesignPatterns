# AndroidObserverDesignPatterns
Android Observer Design Patterns.

Basic explanation:

Ease to manage Singleton Class in apps.
Imagine you have UserEntity Objects used by many activities to show User Profile.

By using Observer, you do not have to repeatedly check whether an object has changed.

Assume to go to the "Edit Profile" page, you must go through the "Detail Profile" page first.
After you change the data on the "Edit Profile" page, Observer serves to tell the "Detail Profile" page is the object UserEntity has been changed.

The Observer have a method you must Override to get updated object.
In this method you can to change the UI component data if required.


Output: https://www.youtube.com/watch?v=B9VXe432sys
