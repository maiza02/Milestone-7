/**
 * 
 */
/**
 * 
 */
module Milestone06 {
    requires com.fasterxml.jackson.databind;
    requires transitive com.fasterxml.jackson.core;
	requires java.desktop;
	requires junit;
    opens Store to com.fasterxml.jackson.databind;
	   
}