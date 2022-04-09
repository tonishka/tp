---
layout: page
title: Nicholas Sun's Project Portfolio Page
---

### Project: Reache

_Reache_ is a desktop app that helps busy working professionals manage their large list
of contacts by providing an easy-to-use interface to store contacts and organize
meetings.

## Summary of Contribution

* **Code Contributed**: [My reposense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=NICSUNXNUS&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18&tabOpen=true&tabType=authorship&tabAuthor=NicsunXnus&tabRepo=AY2122S2-CS2103T-W12-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=functional-code&authorshipIsBinaryFileTypeChecked=false)
 
* **Enhancements Implemented**:
  - Enhanced `ParserUtil` to parse new person fields: company, jobtitle, pronouns
  - Enhanced `ParserUtil` methods for emails, phone numbers and addresses to take in a set of values instead of just one
  - Enhanced `ParserUtil` methods for meeting fields, PR [\#118](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/118/files)
  - Enhanced EditCommandParser class to fit v1.3, PR [\#79](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/79)
  - Added the command and parser classes for adding, editing, deleting and clearing meetings, PRs [\#118](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/118/files), [\#137](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/137) and [\#142](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/142)
  - Implemented more tests to increase code coverage from 53.49% to 61.29%, PR [#\234](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/234)

* **Contributions to the UG**:
  - Partitioning the `command summary` into the Main Window section and Contact Detail Window section, PR [\#206](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/206)
  - Added explanation for choice of two windows, PR [\#205](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/205)
  - Corrections to UG, PRs [\#85](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/85), [\#50](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/50)
  - Authored sections 2.3 - 2.5, PR [\#20](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/20)

* **Contributions to the DG**:
  - Added a user story for v1.3, PR [\#87](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/87)
  - Modified Use Case 1, PR [\#25](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/25)
  - Authored edit feature including the diagrams and explanation: [reposense link](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=nicsunxnus&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-18&tabOpen=true&tabType=authorship&tabAuthor=NicsunXnus&tabRepo=AY2122S2-CS2103T-W12-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs&authorshipIsBinaryFileTypeChecked=false)
  - Added Use Cases 8 to 11, PR [\#237](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/237/files)
  - Modified storage class diagram and added further UML diagrams to explain storage implementation, [\#237](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/237/files)

* **Contributions to the team-based tasks**:
  - Created the team repository
  - Created the collaborative project document 
  - Fixed bug where cancel-all and clear commands does not update the data in the JSON file, PR [\#149](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/149)
  - Reduced number of failing tests after implemenation of new edit command, PR [\#79](https://github.com/AY2122S2-CS2103T-W12-4/tp/pull/79)

* **Contributions beyond the project team**: 
  * Posted [8 issues](https://github.com/nicsunxnus/ped/issues) 
  for [Trackermon](https://github.com/AY2122S2-CS2103T-T09-3/tp) during the PE-D  

* **Contributions to the Developer Guide (Extracts)**:

```markdown
### Logic Component
...
<img src="images/LogicClassDiagram.png" width="550"/>
...
2. if a command is entered from the Home Page, it goes to the AddressBookParser and if it is entered from the Contact Details Page it goes to the ContactDetailsParser.
3. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `AddCommand`) which is executed by the `LogicManager`. The only commands whose creation is specific to the `ContactDetailsParser` class are the `EditCommand` ,`DeleteFieldCommand` and `BackCommand`  classes. General commands applicable to both parsers are the `ExitCommand` and `HelpCommand` classes. 
...
<img src="images/ParserClasses.png" width="600"/>

How the parsing works:
* When called upon to parse a user command, the `AddressBookParser` or `ContactDetailsParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `AddressBookParser` returns back as a `Command` object.
...
### Storage Component
...
![StorageClassDiagram](images/StorageClassDiagram.png)

Here are the other classes that were omitted from the diagram above but are useful to take note of:

![JsonAdapedPersonDiagram](images/JsonAdaptedPerson.png)

![JsonAdaptedMeetingDiagram](images/JsonAdaptedMeeting.png)

The `Storage` component,
* can save both address book, meeting book and user preference data in json format, and read them back into corresponding objects.
* inherits from `AddressBookStorage`, `MeetingBookStorage` and `UserPrefStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
...
## Implementation
...
### Edit feature
The edit mechanism is a feature used to change the details of the contacts. It is only allowed in the application after initiating an add command or view command and in other words, it is functional only in the contact details windows. It is facilitated mainly by the `ContactDetailsParser`, `EditCommandParser` and `EditCommand` classes.

The following sequence diagram shows how the edit operation works:

![EditCommandSequenceDiagram](images/EditCommandSequenceDiagram.png)
- Here, the user executes an add command which takes in a new name input "Jack" which is tagged with a prefix "n/" for input type identification.
- If a user were to execute a view command instead, the only difference would be that the editing is done on an existing contact instead of a new one.

![DetailedParsingForEditSequenceDiagram](images/DetailedParsingForEditSequenceDiagram.png)

Below is an activity diagram summarising the possible paths for an edit command:

![EditActivityDiagram](images/EditActivityDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** Similar to adding a contact, the contact edited cannot have the same **Name** and **Tags** as an existing contact in the addressbook. This is meant to protect against duplicate contacts which may result in confusion for the user in managing their contacts. Attempting to do so will result in a warning message to the user which reads "A person with these details already exists. Please do add tags that differentiate between them!"

</div>

#### Design considerations:

**Aspect: How edit saves:**

* **Alternative 1 (current choice):** Each edit is saved immediately.
    * Pros: Prevents data loss from system crashes.
    * Cons: May have performance issues in terms of memory usage.

* **Alternative 2 :** All edits are saved only after executing a save command (not implemented feature).
    * Pros: Allows user to revert their changes
    * Cons: System crashes will not save the edits.
...
### Use cases
...
**Use case: UC8 - Add a meeting**

**MSS:**
<p>
1. User requests to add a meeting with details. <br>
2. Reache displays the newly added meeting in the list of meetings. <br>
Use case ends.
</p>

**Extensions:** <br>
<p>
1a. User inputs using the wrong format. <br>
&emsp; 1a1. Reache displays an error message. <br>
&emsp; Use case resumes from step 1. <br>
</p>
<p>
2a. Reache informs that the meeting with a same date and time already exists. <br>
Use case resumes at step 1. <br>
</p>

<br>

**Use case: UC9 - Edit meeting details**

**MSS:**
<p>
1. User requests to add details for specific field(s) of the meeting. <br>
2. Reache saves the specified details along with their respective field(s). <br>
Use case ends.
</p>

**Extensions:** <br>
<p>
1a. User inputs the wrong format. <br>
&emsp; 1a1. Reache displays an error message. <br>
&emsp; Use case resumes from step 1.
</p>
<p>
2a. Reache informs that the meeting with a same date and time already exists. <br>
Use case resumes at step 1. <br>
</p>

<br>

**Use case: UC10 - Delete a meeting**

**MSS:**
<p>
1. User requests to delete a meeting. <br>
4. Reache deletes the meeting. <br>
Use case ends.
</p>

**Extensions:**
<p>
1a.  The requested meeting does not exist. <br>
&emsp; 1a1. Reache displays an error message. <br>
&emsp; Use case resumes at step 1.
</p>

<br>

**Use case: UC11 - Clear all meetings**

**MSS:**
<p>
1. User requests to clear all meetings
2. Reache asks for confirmation. <br>
3. User confirms the action. <br>
4. Reache clears all meetings. <br>
Use case ends.
</p>

**Extensions:**
<p>
3a.  User chooses to cancel clearing contacts. <br>
&emsp; 3a1. Reache cancels the clearing. <br>
&emsp; Use case ends.
</p>
...
## **Appendix: Instructions for manual testing**
...
### Adding a meeting

1. Adding a meeting
   
   1. Prerequisites: Have an empty meeting list and 1 contact in the contacts list. The list of test cases have to be followed in order for the testing to work.
   2. Test case: `meet with/1 for/Product Demo with Client in/Conference Room 5A on/05-04-2025 15:44` <br>
      Expected: The added meeting is shown on the list of meetings at the side and a success message is displayed
   3. Test case: `meet with/2 for/Product Demo with Client in/Conference Room 5A on/05-04-2025 15:44` <br>
      Expected: No meeting is added and an error message is shown in the status box.
   4. Test case: `meet with/1 for/Product Demo with Client in/Conference Room 5A on/05-04-2025 15:44` <br>
      Expected: No meeting is added and an error message is shown in the status box.
   5. Test case: `meet with/ for/Product Demo with Client in/Conference Room 5A on/05-04-2025 15:44` <br>
      Expected: No meeting is added and an error message is shown in the status box.
   6. Test case: `meet with/1 for/ in/Conference Room 5A on/05-04-2025 15:44` <br>
      Expected: No meeting is added and an error message is shown in the status box
   7. Test case: `meet with/1 for/Product Demo with Client in/ on/05-04-2025 15:44` <br>
      Expected: No meeting is added and an error message is shown in the status box
   8. Test case: `meet with/1 for/Product Demo with Client in/Conference Room 5A on/` <br>
      Expected: No meeting is added and an error message is shown in the status box
   9. Test case: `meet with/1 for/Product Demo with Client in/Conference Room 5A on/2025-05-04 15:44`
      Expected: No meeting is added and an error message is shown in the status box
...
```
