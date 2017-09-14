# Soccer Stats

Soccer Stats is an example application to be used as a proof of concept for a presentation at [Ansible Meetup in São Paulo](https://www.meetup.com/Ansible-Sao-Paulo/events/243212921/).

## Pre-requistes

* JDK 1.8
* Maven 3.3+

## Environment

It's a sample Rest API built upon Spring Rest Framework. The database is based on data gathered from 2015/2016 season of Italian Soccer National Championship.

During the Spring Context bootstrap a temporary database is created using H2 with data imported from a spreedsheet.

## Installation

Just run `mvn clean package` on the project directory and your ready to go.

## Using

Bring the application up by running `java -jar soccer-stats-X.X.X.jar`, where's `X.X.X` is the project's version.

After the startup the endpoint should be availble at `http://localhost:8080/matches/{team_name}` where `{team_name}` must be a Italian team name like `juventus`, `milan`, `udinese` and so on.

To bring a specific match, try the endpoint `http://localhost:8080/matches/{home_team_name}/{visitor_team_name}` replacing the param vars to the match you'd like to see, for example:

[http://localhost:8080/matches/juventus/milan](`http://localhost:8080/matches/juventus/milan`)

## Credits

[Football-Data](http://www.football-data.co.uk/) for providing the data used for this lab.