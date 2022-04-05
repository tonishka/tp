---
layout: page
title: Murad Durrani's Project Portfolio Page
---

### Project: Reache

_Reache_ is a desktop app that helps busy working professionals manage their large list
of contacts by providing an easy-to-use interface to store contacts and organize
meetings.

## Summary of Contributions

* **Code Contributed**: [tP Code Dashboard Link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18&tabOpen=true&tabType=authorship&zFR=false&tabAuthor=muraddurrani&tabRepo=AY2122S2-CS2103T-W12-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false)
* **Enhancements Implemented**:
  * Added classes for new types of information to be associated with a person (i.e. `Company`, `JobTitle`, etc.), and integrated them into the Model component.
  * Implemented having a unique `Id` for a `Person`, which was used for all `Meeting` related functionality.
  * Added `Label`, which is used to label a `Person`'s contact information. In addition, implemented functionality for automatically creating default labels when none are provided by the user, and for ensuring that duplicate labels are not created in `LabelUtil`.
  * Implemented `ContactDetailsParser`, which is responsible for parsing user input in the `ContactDetailsWindow`.
  * Created the `ContactDetailsWindow` and its UI components (`ContactDetailsPanel`, `ParticularsCard`, etc.), which are responsible for displaying all a person's contact details, and implemented the necessary navigation logic to change screens.
  * Created `MeetingListPanel` and `ContactMeetingsPanel` and their UI components, which are responsible for displaying all the user's meetings, and the meetings associated with a specific contact, respectively.
  * Implemented `AddCommand` to add a new `Person` to the Address Book.
  * Implemented `ViewCommand` to navigate to the `ContactDetailsWindow` to view a specific `Person`'s complete contact information.
    

* **Contributions to the UG**:
  * Added documentation for the features `edit`, `delete contact`, `clear`, `find`, `list`, and `view`.
  * Added the Overview and Interface Guide sections as part of the Introduction.


* **Contributions to the DG**:
  * Added the table of user stories.
  * Added implementation details of the `view` feature.


* **Contributions to the team-based tasks**:
  * Documented the purpose of the user guide in the UG.
  
  
* **Review/mentoring contributions**:
  * PRs reviewed with meaningful comments: [#33](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/33), [#57](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/57), [#142](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/142)
