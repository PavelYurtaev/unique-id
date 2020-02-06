1. postgresql db name: "unique"
   user: "postgres"

2. ./gradlew build

3. java -jar build/libs/unique-id-app-0.0.1-SNAPSHOT.jar

4. GET localhost:8080/id

result example:

{
  "id": 5
}
