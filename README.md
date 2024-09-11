# Smart Home Appliance Control Solution

## Overview

This project is a smart home appliance control solution, implemented as part of a Programmer/Analyst assessment. The solution is designed to control various home appliances, including a Light, Fan, and Air Conditioner. Each appliance has its own unique way of being turned on and off. Additionally, the system performs an automatic update once a year, where all devices are turned off at **January 1st, 1:00 AM** local time.

## Features

- **Control Appliances**: The system provides the ability to toggle the state of the following appliances:
  - **Light**: The light can be turned on and off by toggling a switch.
  - **Fan**: The fan can be turned off by reducing its speed to zero. The fan supports three states: 
    - `0` = off
    - `1` = low speed
    - `2` = high speed
  - **Air Conditioner**: The air conditioner can be turned off by setting the thermostat to the "off" mode.

- **Automatic System Update**: 
  - The system will automatically perform an update every year at **January 1st, 1:00 AM** local time. During this update, all devices are turned off.
  - No other actions are performed during the update.

## How It Works

### Appliances:

- **Light**: Toggled by switching between the `ON` and `OFF` states.
- **Fan**: Toggled by adjusting the fan speed. The fan turns off when the speed is reduced to `0`.
- **Air Conditioner**: The air conditioner turns off when its mode is set to `OFF`.

### System Update:

- At **January 1st, 1:00 AM** local time, the system automatically updates by turning off all devices.
- After the update, no further actions are taken.

## Classes

- **Light**: Represents the light appliance, which can toggle between `ON` and `OFF`.
- **Fan**: Represents the fan appliance, which supports three states: `OFF`, `low speed`, and `high speed`.
- **AirConditioner**: Represents the air conditioner appliance, which toggles between `ON` and `OFF` mode.
- **Main**: The main class that handles user interaction, system update logic, and toggling of appliances.


