---
layout: page
title: User Guide
---

Reache is a desktop app that helps busy working professionals manage their large list of contacts by providing an easy-to-use interface to store contacts and organize meetings. Reache is especially suited for professionals who would like to optimize their contact management by using a Command Line Interface (CLI).


## Table of Contents
- Quick Start
- Features
   - Managing Contacts
   - Finding Contacts
   - Editing Information
   - Viewing Help
   - Exiting the program

--------------------------------------------------------------------------------------------------------------------

## 1. Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `reache.jar` from [here](https://github.com/AY2122S2-CS2103T-W12-4/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your Reache.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds [Disclaimer: Actual GUI not shown]. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## 2. Features
### 2.1 Managing Contacts
#### 2.1.1 Adding a contact: `add`
Adds a person to the contact list.

Format: `add <NAME>`

After adding a person to the contact list, you will be navigated to their contact details page. 
From this page, you can edit their contact details using the commands found under the [Editing Information](#23-editing-information) section.

Example: `add Alex Dunphy`

#### 2.1.2 Editing a contact: `edit`
Navigates you to the specified person's contact details page, where you can edit their contact information.

Format: `edit <INDEX NO>`

All commands that can be used to edit contact details can be found under the [Editing Information](#23-editing-information) section.

#### 2.1.3 Deleting a contact: `del`
Deletes the specified person from the address book.

Format: `del <INDEX NO>`

Example: `del 66`

#### 2.1.4 Clearing all contacts: `clear`
Clears all contacts from the address book.

Format: `clear`

#### 2.1.5 Saving changes
_Reache_ saves to the hard disk automatically after any command is issued that changes the data. There is no need to save manually.

#### 2.1.6 Editing the data file
_Reache_ data is saved as a JSON file at [_Reache_ Jar file location]/data/reache.json. Advanced users are welcome to update data directly by editing the data file.

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

