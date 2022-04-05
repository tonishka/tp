---
layout: page title: Charisma Kausar's Project Portfolio Page
---

### Project: Reache

_Reache_ is a desktop address book application used for teaching Software Engineering principles. The user interacts
with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

## Summary of Contribution

* **Code Contributed**: [RepoSense Link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=ckcherry23&breakdown=true&sort=groupTitle&sortWithin=title&since=2022-02-18&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)


* **Enhancements Implemented**: 
  * Implemented a new feature to `delete` specific fields of a contact
  * Enhanced the `clear` command by asking for user confirmation
    * Created a new 'ConfirmWindow' with reusability in mind for any future commands that require user confirmation.


* **Contributions to the UG**: 
  * Added the `Managing Meetings` section under `Features`
  * Created the tables for `Commands Summary`, `Contact Fields Summary` and `Meeting Fields Summary`


* **Contributions to the DG**: 
  * Added the `Delete fields feature` under `Implementation` along with its design decisions.
  * Added the `Clear address book feature` under `Implementation` along with its sequence diagram and activity diagram.
  * Mentioned the `Non-functional requirements`.
  * Added a `Glossary` for better user readability.


* **Contributions to the team-based tasks**:
  * Managed [labels](https://github.com/AY2122S2-CS2103T-W12-4/tp/labels) for issue-tracking and PRs
  * Set up milestones [v1.1](https://github.com/AY2122S2-CS2103T-W12-4/tp/milestone/1), 
  [v1.2](https://github.com/AY2122S2-CS2103T-W12-4/tp/milestone/2), 
  [v1.2b](https://github.com/AY2122S2-CS2103T-W12-4/tp/milestone/3), 
  [v1.3b](https://github.com/AY2122S2-CS2103T-W12-4/tp/milestone/5) and 
  [v1.4](https://github.com/AY2122S2-CS2103T-W12-4/tp/milestone/6) on the issue-tracker.
  * Set up GitHub Project boards with the _automated kanban with reviews_ template for 
  [v1.1](https://github.com/AY2122S2-CS2103T-W12-4/tp/projects/1),
  [v1.2](https://github.com/AY2122S2-CS2103T-W12-4/tp/projects/3),
  [v1.3](https://github.com/AY2122S2-CS2103T-W12-4/tp/projects/4),
  [v1.4](https://github.com/AY2122S2-CS2103T-W12-4/tp/projects/6).


* **Review/mentoring contributions**: `to be added soon`


* **Contributions beyond the project team**: `to be added soon`


* **Contributions to the Developer Guide (Extracts)**:

```markdown
### Clear address book feature
The **clear address book** feature can be used to delete all the contacts stored by 
the user and to start with a new address book. Since deleted data cannot be recovered, 
the app opens a pop-up window asking for confirmation that the user wants to delete 
all of their stored contacts.

The following sequence diagram shows how the clear operation works:

![ClearSequenceDiagram](../images/ClearSequenceDiagram.png)

This activity diagram summarises the possible paths of executing the _clear_ command:

![ClearActivityDiagram](../images/ClearActivityDiagram.png)
```


* **Contributions to the User Guide (Extracts)**: 

```markdown
#### 3.3.1 Creating a meeting: `meet`
Create a meeting by specifying the following information:
- Agenda
- Meeting place
- Meeting date and time: in DD-MM-YYYY HH:mm format
- Attendees: in the form of index numbers of people on the displayed list

_Note:_ All fields are compulsory.

Format: `meet for/<AGENDA> in/<MEETING PLACE> on/<MEETING DATE AND TIME> 
with/<ATTENDEE 1 INDEX> [<ATTENDEE 2 INDEX>]…`

Example: `meet for/Project Discussion in/UTown on/28-04-2022 13:30 with/1 3 4`
```