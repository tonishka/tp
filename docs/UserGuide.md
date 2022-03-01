
Reache User Guide :book:   
-

Reache is a desktop app that helps **busy working professionals** manage their large list of contacts by providing an easy-to-use interface to store contacts and organize meetings. Reache is especially suited for professionals who would like to optimize their contact management by using a **Command Line Interface (CLI)**.

* Table of contents
    - [Quick start](##quick-start)
    - [Features](##features)
      - [Managing contacts](##managing-contacts)
      - [Finding contacts](##finding-contacts)
      - [Editing information](##editing-information)
      - [Viewing help](##viewing-help)
      - [Exiting the program](##exiting-the-program)
    - [Command summary](##command-summary)
    - [Contact fields summary](##contact-fields-summary)

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have `java 11` installed in your Computer.
    1. Open the `terminal` (Mac/Linux users) or the `command prompt` (Windows User) and run java -version, like so:
    2. If you do not have `java 11` installed, follow the guide given [here](https://github.com/AY2122S2-CS2103T-W12-4/tp/releases).

1. Download the latest `reache.jar` from [here](https://github.com/AY2122S2-CS2103T-W12-4/tp/releases).

1. Copy the file to the folder you want to use as the home folder for Reache.

1. Double-click the file to start the app.
--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` inside angle brackets are the parameters to be supplied by the user.<br>
  e.g. in `add <NAME>`, `NAME` is a parameter which can be used as `add John Doe`.
  
* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.
  
* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`

## Contact Field summary
Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`


