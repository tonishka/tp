---
layout: page
title: Nicholas Sun's Project Portfolio Page
---

### Project: Reache

_Reache_ is a desktop address book application used for teaching Software Engineering principles. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

## Summary of Contribution
* **Responsibilities**: In charge of updating `Parser` and `Commands`
* **Code Contributed**: [My reposense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=NICSUNXNUS&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18&tabOpen=true&tabType=authorship&tabAuthor=NicsunXnus&tabRepo=AY2122S2-CS2103T-W12-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=functional-code&authorshipIsBinaryFileTypeChecked=false) 
* **Enhancements Implemented**:
  - Enhanced `ParserUtil` to parse new person fields: company, jobtitle, pronouns
  - Enhanced AB3's `ParserUtil` methods for emails, phone numbers and addresses to take in a set of values instead of just one
  - Added the command and parser classes for adding, editing, deleting and clearing meetings
  - Added more tests to increase coverage from ?? to ?? in PRs (...) (coming soon)
* **Contributions to the UG**:
  - Partitioning the `command summary` into the Main Window section and Contact Detail Window section, PR [\#206]()
  - Added explanation for choice of two windows, PR [\#205]()
  - Corrections to UG, PRs [\#85](), [\#50]()
  - Authored sections 2.3 - 2.5, PR [\#20]()
* **Contributions to the DG**:
  - Added a user story for v1.3, PR [\#87]()
  - Modified Use Case 1, PR [\#25]()
  - Authored edit feature including the diagrams and explanation: [reposense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=nicsunxnus&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18&tabOpen=true&tabType=authorship&tabAuthor=NicsunXnus&tabRepo=AY2122S2-CS2103T-W12-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs&authorshipIsBinaryFileTypeChecked=false)
* **Contributions to the team-based tasks**:
  - Created the team repository
  - Created the collaborative project document 
  - Fixed bug where cancel-all and clear commands does not update the data in the JSON file, PR [\#149]()
* **Contributions to the Developer Guide (Extracts)**:
   - Edit Sequence Diagram: <br> ![EditCommandSD](https://github.com/AY2122S2-CS2103T-W12-4/tp/blob/master/docs/images/EditCommandSequenceDiagram.png)
   - Edit detailed parsing Sequence Diagram: <br> ![Parsing SD](https://github.com/AY2122S2-CS2103T-W12-4/tp/blob/master/docs/images/DetailedParsingForEditSequenceDiagram.png)
   - Edit Activity Diagram: <br> ![ActivityDiagram](https://github.com/AY2122S2-CS2103T-W12-4/tp/blob/master/docs/images/EditActivityDiagram.png)
