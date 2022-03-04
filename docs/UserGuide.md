---
layout: page
title: User Guide
---

Reache is a desktop app that helps busy working professionals manage their large list of contacts by providing an easy-to-use interface to store contacts and organize meetings. Reache is especially suited for professionals who would like to optimize their contact management by using a Command Line Interface (CLI).


## Table of Contents
- [Quick Start](#1-quick-start)
- [Features](#2-features)
   - [Managing Contacts](#21-managing-contacts)
   - [Finding Contacts](#22-finding-contacts)
   - [Editing Information](#23-editing-information)
   - [Viewing Help](#24-viewing-help-help)
   - [Exiting the program](#25-exiting-the-program-exit)
- [Command Summary](#3-command-summary)
- [Contact Fields Summary](#4-contact-fields-summary)

--------------------------------------------------------------------------------------------------------------------

## 1. Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `reache.jar` from [here](https://github.com/AY2122S2-CS2103T-W12-4/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your Reache.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds [Disclaimer: Actual GUI not shown]. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Refer to the Features below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## 2. Features
### 2.1 Managing Contacts
#### 2.1.1 Adding a contact: `add`
Adds a person to the contact list.

Format: `add <NAME>`

After adding a person to the contact list, you will be navigated to their contact details page. 
From this page, you can edit their contact details using the commands found under the [Editing Information](#23-editing-information) section.

Example: `add Alex Dunphy`

#### 2.1.2 Clearing all contacts: `clear`
Clears all contacts from the address book.

Format: `clear`

#### 2.1.3 Deleting a contact: `del`
Deletes the specified person from the address book.

Format: `del <INDEX NO>`

Example: `del 66`

#### 2.1.4 Editing a contact: edit
Enters editing mode to modify contact details in the address book.

Format: `edit <INDEX NO> `

Information about the details that can be added is found under the [Editing Information](#23-editing-information) section.

Example: `edit 4`

#### 2.1.5 Editing the data file
_Reache_ data is saved as a JSON file at [_Reache_ Jar file location]/data/reache.json. Advanced users are welcome to update data directly by editing the data file.

#### 2.1.6 Saving changes
_Reache_ saves to the hard disk automatically after any command is issued that changes the data. There is no need to save manually.

### 2.2 Finding Contacts
#### 2.2.1 Finding contacts: `find`
Finds a person based on a search category and the value provided. Searchable categories can be found in the [Editing Information](#23-editing-information) section.

Format: `find <FIELD> <VALUE>`

Examples:<br>
`find company Tesla` Finds all contacts who work in Tesla.<br>
`find name Michael Scott` Finds all contacts with the name Michael Scott.<br>
`find tag supplier` Finds all contacts who are tagged as Supplier.

#### 2.2.2 Listing all contacts: `list`
Shows a list of all contacts in the address book.

Format: `list`

#### 2.2.3 Viewing a person's full details: `view`
Expands the view to display all the specified peron's contact information.

Format: `view <INDEX NO>`

Example: `view 34`

### 2.3 Editing Information
*Note:*
1. To edit existing information, adding a new entry with the same category/label as the existing entry will overwrite it with the new one. 
2. Difference between tags and labels: Labels distinguish multiple entries in the same field whereas tags group together any number of contacts based on some criterion.

#### 2.3.1 Symbols Legend
| Symbol | Meaning |
|-------|---------|
|...| Indicates that the preceding entry can be provided multiple times.|
|;|Used to separate entries when multiple entries are provided. <p>E.g. `phone 12345678; 43214321` denotes two phone numbers.</p>|
|/|Used to indicate a label for the preceding field. <p>Labels are optional and if not provided, a default label will be assigned.E.g. `phone 12345678 /personal` labels the given number a personal number.</p>|
|<...>|Indicates the argument that the user should provide in that area|

#### 2.3.2 Add/Edit phone numbers: phone
Format: `phone <NUMBER 1> /<LABEL>; <NUMBER 2> /<LABEL>...`

Example: `phone 98765432 /Personal; phone 9753468 /Office`

#### 2.3.3 Add/Edit emails: `email`
Format:  `email <EMAIL 1> /<LABEL>; <EMAIL 2> /<LABEL>...`

Example: -email alex@reache.com /Official; email alex98@gmail.com- 

#### 2.3.4 Add/Edit address: `address`

Format: `address <ADDRESS 1> /<LABEL>; <ADDRESS 2> /<LABEL>...`

Example: `address 28 Francis Mine, Sacramento, CA - 654321 /Home`  

#### 2.3.5 Add/Edit company: `company`

Format: `company <COMPANY>`

Example: `company Tesla`

#### 2.3.6 Add/Edit job title: `job`

Format: `job <JOB TITLE>`

Example: `job Software Engineer` 

#### 2.3.7 Add/Edit tags: `tag`

Format: `tag <TAG 1>; <TAG 2>...`

Example: `tag Media Contact; Has kids`

#### 2.3.8 Add/Edit pronoun: `pronoun`

Format: `pronoun <PRONOUNS>`

Example: `pronoun He/Him`

#### 2.3.9 Delete field: `del`

Format: `del <TYPE> <LABEL>`

`<TYPE>` refers to the category of information you wish to delete, as indicated by its command word.

Without a `<LABEL>`, the command will delete all information stored in `<TYPE>`.

Examples:

`del phone personal` -    Deletes the personal phone number of the contact.

`del address` -         Deletes all addresses of the contact.

`del email Official` -   Deletes the Official email of the contact.
   
#### 2.4 Viewing help: `help`
Shows a message explaining how to access the help page.

Format: `help`
   
#### 2.5 Exiting the program: `exit`
Exits the program.

Format: `exit`

## 3. Command Summary

| **Action** | **Format, Example** |
| --- | --- |
| **Add** | Format: `add <NAME>` <br> Example: `add Alex Dunphy` |
| **Edit** | Format: `edit <INDEX NO>` <br> Example: `edit 4` |
| **Save** | Format: `save` |
| **Delete** | **Deleting contacts** <br> Format: `del <INDEX NO>` <br> Example: `del 88` <br> <br> **Deleting fields** <br> Format: `del <FIELD> <LABEL>` <br> Example: `del phone personal` |
| **Clear** | Format: `clear` |
| **Find** | Format: `find <FIELD> <VALUE>` <br> Example: `find name Michael Scott` |
| **View** | Format: `view` |
| **List** | Format: `list` |
| **Help** | Format: `help` |

## 4. Contact Fields Summary

| **Field** | **Mandatory** | **Format, Example** |
| --- | --- | --- |
| **Name** | Yes | Format: `add <NAME>` <br> Example: `add Alex Dunphy` |
| **Phone Number** | No | Format: `phone <NUMBER 1> /<LABEL>; <NUMBER 2> /<LABEL>...` <br> Example: `phone 98765432 /Personal; phone 9753468 /Office` |
| **Email ID** | No | Format: `email <EMAIL 1> /<LABEL>; <EMAIL 2> /<LABEL>...` <br> Example: `email alex@reache.com /Official; email alex98@gmail.com` |
| **Address** | No | Format: `address <ADDRESS 1> /<LABEL>; <ADDRESS 2> /<LABEL>...` <br> Example: `address 28 Francis Mine, Sacramento, CA - 654321 /Home` |
| **Company** | No | Format: `company <COMPANY>` <br> Example: `company Tesla` |
| **Job Title** | No | Format: `job <JOB TITLE>` <br> Example: `job Software Engineer` |
| **Tags** | No | Format: `tag <TAG 1>; <TAG 2>...` <br> Example: `tag Media Contact; Has kids` |
| **Pronouns** | No | Format: `pronoun <PRONOUNS>` <br> Example: `pronoun They/Them` |

[Back to top](#table-of-contents)
