# dateTime

Program that reads a large list of date-time values from a file and writes to a separate file the list of unique, valid date-time values (no duplicates). A valid date-time value matches the following format (ISO 8601):
YYYY-MM-DDThh:mm:ssTZD

// currently does not check duplicates of datetimeoffset (ex. same time in EST as Z)
