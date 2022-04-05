---
layout: page title: Charisma Kausar's Project Portfolio Page
---

### Project: Reache

_Reache_ is a desktop address book application used for teaching Software Engineering principles. The user interacts
with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

## Summary of Contribution

* **Code Contributed**: [RepoSense Link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=ckcherry23&breakdown=true&sort=groupTitle&sortWithin=title&since=2022-02-18&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)


* **Enhancements Implemented**: 
  * Deleting specific fields of a contact
  * Confirmation window for clearing address book


* **Contributions to the UG**: 
  * Managing meetings
  * Commands summary
  * Contact fields Summary
  * Meeting fields summary


* **Contributions to the DG**: 
  * Delete fields feature
  * Clear address book feature
  * Non-functional requirements
  * Glossary


* **Contributions to the team-based tasks**:
  * Managed labels for issue-tracking and PRs
  * Set up milestones `v1.2`, `v1.2b`, `v1.3b` and `v1.4` on the issue-tracker
  * Set up GitHub Project boards with the _automated kanban with reviews_ template for milestone management


* **Review/mentoring contributions**: `to be added soon`


* **Contributions beyond the project team**: `to be added soon`


* **Contributions to the Developer Guide (Extracts)**:

```markdown
### Clear address book feature
The **clear address book** feature can be used to delete all the contacts stored by the user 
and to start with a new address book. Since deleted data cannot be recovered, 
the app opens a pop-up window asking for confirmation that 
the user wants to delete all of their stored contacts.

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

Format: `meet for/<AGENDA> in/<MEETING PLACE> on/<MEETING DATE AND TIME> with/<ATTENDEE 1 INDEX> [<ATTENDEE 2 INDEX>]…`

Example: `meet for/Project Discussion in/UTown on/28-04-2022 13:30 with/1 3 4`
```