package com.example.networkmeup.domain;

import java.io.Serializable;

/**
 * Enum representing the availability status of something.
 */
public enum Availability implements Serializable {
    Available, // Represents availability
    Temporarily_Unavailable, // Represents temporary unavailability
    Closed // Represents closed/unavailable status
}
