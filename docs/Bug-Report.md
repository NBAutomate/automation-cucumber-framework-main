# QA BUG REPORT

**Project:** Shady Meadows B&B Website  
**URL:** https://automationintesting.online/  
**Reported By:** Nisha — QA Analyst/Lead  
**Date:** 13/07/2025

## FUNCTIONAL BUGS — HOTEL BOOKING

### BNB-001 — Overlapping Booking Allowed
**Steps:** Book same room for same dates twice.  
**Expected:** Prevent conflict.  
**Actual:** Both bookings accepted.  
**Severity:** High

### BNB-002 — Inconsistent Language
**Steps:** View Home and Rooms Page.  
**Expected:** The whole content of Page should be in a consistent language (English).  
**Actual:** Room Details description is inconsistent with English language.  
**Severity:** High (User won’t understand)

### BNB-003 — Booking in Past Date
**Steps:** Book room with past date in check-in field.  
**Expected:** Should not allow checking availability or reserving rooms in the past.  
**Actual:** Able to check availability and reserve rooms for past dates.  
**Severity:** Medium

### BNB-004 — Error Descriptions Should Be Clear
**Steps:** Successful Booking with valid email and dates.  
**Expected:** Confirmation email should be sent for booking.  
**Actual:** Error descriptions are vague. Not clear for which field size is required.  
**Severity:** Medium

### BNB-005 — Booking Without Confirmation Email or Text
**Steps:** Successful Booking with valid email and dates.  
**Expected:** Confirmation email should be sent for booking.  
**Actual:** No confirmation is sent for booking done.  
**Severity:** Low

### BNB-007 — Header Navigation Link Not Working
**Steps:** Click on Page Navigation link in Booking page.  
**Expected:** Should navigate back through header links (e.g., Home > Rooms > Double Room). Should navigate back to Home or Rooms.  
**Actual:** Back Link is not working for Rooms to check all Rooms.  
**Severity:** Medium

### BNB-008 — Changing Dates Through Booking Page
**Steps:** Click on Page Navigation link in Booking page.  
**Expected:** Should be able to check availability and change dates through sub page Room calendar.  
**Actual:** Unable to check availability and change dates through selected Room page.

### BNB-009 — Website Performance Load Time
**Steps:** Click on Website URL.  
**Expected:** All rooms should load with proper images.  
**Actual:** Rooms not loading completely, broken images observed.  
