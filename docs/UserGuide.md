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

