---
layout: page
title: Murad Durrani's Project Portfolio Page
---

### Project: Reache

_Reache_ is a desktop app that helps busy working professionals manage their large list
of contacts by providing an easy-to-use interface to store contacts and organize
meetings.

## Summary of Contributions
* **Code Contributed**: [RepoSense Link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=muraddurrani&breakdown=true&sort=groupTitle&sortWithin=title&since=2022-02-18&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)


* **Enhancements Implemented**:
  * Added classes for new types of information to be associated with a person (i.e. `Company`, `JobTitle`, etc.), and integrated them into the Model component: [#30](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/30)
  * Implemented having a unique `Id` for a `Person`, which was used for all `Meeting` related functionality: [#120](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/120)
  * Added `Label`, which is used to label a `Person`'s contact information: [#110](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/110)
  * Implemented functionality for automatically creating default labels when none are provided by the user, and for ensuring that duplicate labels are not created, in `LabelUtil`: [#156](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/156)
  * Implemented `ContactDetailsParser`, which is responsible for parsing user input in the `ContactDetailsWindow`: [#42](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/42)
  * Created the `ContactDetailsWindow` and its UI components (`ContactDetailsPanel`, `ParticularsCard`, etc.), which are responsible for displaying all a person's contact details, and implemented the necessary navigation logic to change screens: [#42](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/42)
  * Created `MeetingListPanel` and its UI components, which is responsible for displaying all the user's meetings: [#140](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/140)
  *  Created `ContactMeetingsPanel` and its UI components, which is responsible for displaying meetings that the user has with a specific contact in the `ContactDetailsWindow`: [#145](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/145)
  * Implemented `AddCommand` to add a new `Person` to the Address Book. [#60](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/60)
  * Implemented `ViewCommand` to navigate to the `ContactDetailsWindow` to view a specific `Person`'s complete contact information. [#71](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/71)
    

* **Contributions to the UG**:
  * Added documentation for the features `edit`, `delete contact`, `clear`, `find`, `list`, and `view`: [#16](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/16)
  * Added the Overview and Interface Guide sections as part of the Introduction: [#152](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/152)


* **Contributions to the DG**:
  * Added the table of user stories [#17](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/17)
  * Added implementation details of the `view` feature: [#100](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/100)


* **Contributions to the team-based tasks**:
  * Documented the purpose of the user guide in the UG: [#216](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/216)
  * Maintained issues in issue tracker, for example: [#51](https://github.com/AY2122S2-CS2103T-W12-4/tp/issues/51), [#53](https://github.com/AY2122S2-CS2103T-W12-4/tp/issues/53), [#54](https://github.com/AY2122S2-CS2103T-W12-4/tp/issues/54)
  * Updated Reache's responses to the user: [#124](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/124)
  
  
* **Review/mentoring contributions**:
  * PRs reviewed with meaningful comments: [#33](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/33), [#57](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/57), [#142](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/142)


* **Contributions beyond the project team**:
  * Wrote [5 issues](https://github.com/muraddurrani/ped/issues) for Harmonia during the PE-D


* **Contributions to the Developer Guide (Extracts)**:
```markdown
### View person feature

The view feature allows the user to view the full contact details of a specified person in the address book. The command is only available from the person list window,and is thus facilitated by the `AddressBookParser`, `ViewCommandParser`, and `ViewCommand`. Additionally, it implements the following operation:

* `MainWindow#LoadContactScreen(Person personToDisplay)` — Constructs and shows a `ContactDetailsPanel`, which displays the full details of the `Person` provided as argument.

Given below is an example usage scenario and how the view mechanism behaves at each step.

Step 1. From the person list window, the user executes `view 2` to view the contact details of the second person in the address book. A `ViewCommand` is constructed with the index of the person to de displayed.

Step 2. The `ViewCommand` is executed, and the person that corresponds to the provided index is returned to the `MainWindow` inside a `CommandResult`.

Step 3. `MainWindow#loadContactScreen(Person personToDisplay)` is executed with the specified person passed as argument, which constructs and displays the respective `ContactDetailsPanel`.

The following sequence diagram shows how the view feature works:

![ViewSequenceDiagram](images/ViewCommandSequenceDiagram.png)
```
* **Contributions to the User Guide (Extracts)**:
```markdown  
Upon launching Reache, you will see the Main Window, which is depicted below. The Main Window displays your entire contact list as well as all upcoming meetings you have planned.

![Main Window](/images/MainWindow.png)

The Main Window contains the following elements:
1. **Menu Bar**: Contains Reache's options and help.
2. **Command Box**: A dialog box from which you can type commands to use Reache.
3. **Result Display**: When you use the Command Box to enter a command, Reache will show the result of that command here.
4. **Contact List**: A list of all your contacts, sorted alphabetically. Each contact has a corresponding index number, which you can use to refer to that contact in commands.
5. **Meeting List**: A list of all your upcoming meetings, sorted chronologically. As with contacts, each meeting has a corresponding index number for use in commands.
```