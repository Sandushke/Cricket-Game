import random

#-------------- Display the main menue---------------------------
def main_menue():
    print("-----------Welcome to World Cricket Championship 2021----------")
    print()
    print("GAME RULES AND HOW IT IS PLAYED:-")
    print()
    print("1. You can select a team from either Team A or Team B")
    print("2. Then the computer will also select a random team from the team which you chose")
    print("3. IF you win the toss you can choose either to bat or ball")
    print("4. IF you loose the toss you will have to ball first")
    print("5. You can edit and customise your time before the game but after the game start "
          "\n "" you are not allowed to change the team profile")
    print("6. After evey over you can choose whether to resume or exit the game")
    print("7. After 20 overs or if a team gets 10 wickets the match will end")
    print("8. The computer will provide the final match summary in a text file")

    print()
    print("Do you want a match from Group A or Group B: \n[1]Group A \n[2]Group B")


# ----------------Printing the two selected teams one below the other--------------------
def displayGroupTeam(team1, team2, players_array):
    for i in players_array[team1]:
        print(i)
    print(" ")
    for i in players_array[team2]:
        print(i)


#-------------- Editing the team players--------------------
def editPlayer(group, index):
    while True:
        playerName = input("Enter player name: ").capitalize()
        if playerName in group[index]:
            playerIndex = group[index].index(playerName)
            break
        else:
            print("Invalid Player Name")
    newPlayerName = input("Edit Player name: ")
    group[index][playerIndex] = newPlayerName


# -------------------- Batting Scenario----------------------------
def battingScenario(score_card, tailing_score=1000):
    balls = 0
    wickets = 0
    run_score = 0
    wicket_outputs = ("LBW! You're out", "Run out Run out!!! You're out", "Opps it's a catch! You're out")
    baller = 0
    ballers_wickets = 0
    ballers_ball_count = 0
    batsman = 0
    batsman_score = 0


    while balls != 120 or wickets != 10:
        if ballers_ball_count == 6:
            score_card[1][baller] = ballers_wickets
            if baller == 10:
                baller = 0
            else:
                baller += 1
            ballers_ball_count = 0
            ballers_wickets = 0
        if run_score >= tailing_score != 1000:
            break

        pc_ball_value = random.randint(1, 6)  # value of a single ball
        user_bat_score = int(input("Enter your a number between 1 to 6 here:"))
        # ----------------batting score for a single ball------------------
        print("PC ball value:", pc_ball_value)

        if pc_ball_value == user_bat_score:
            rand = random.choice(wicket_outputs)
            print(rand)
            score_card[0][batsman] = batsman_score
            user_bat_score = 0
            wickets += 1
            ballers_wickets += 1
            if wickets == 10:
                print("All out")
                break
            else:
                batsman += 1
            batsman_score = 0

        if user_bat_score < 1 or user_bat_score > 6:
            print("Invalid user input. Please enter another number")
        else:
            run_score += user_bat_score
            batsman_score += user_bat_score

        balls += 1
        ballers_ball_count += 1
        print("Total Score:", run_score, "/", wickets)
        print("Remaining balls:", 120 - balls)

        while True:
            try:
                decision = str(input("Do you want to resume the game:"))
            except ValueError:
                print("Invalid Input")
            except TypeError:
                print("Invalid Input")

            if decision == "yes" or decision == "no":
                break
            else:
                print("Invalid Input")

        if decision == "no":
            print("Exit the game")
            score_card[1][baller] = ballers_wickets
            score_card[0][batsman] = batsman_score
            break
        else:
            print()
    return run_score, wickets, balls

# -------------------- Balling Scenario----------------------------
def ballingScenario(score_card, tailing_score=1000):
    balls = 0
    wickets = 0
    run_score = 0
    wicket_outputs = ("LBW! You're out", "Run out Run out!!! You're out", "Opps it's a catch! You're out")
    baller = 0
    ballers_wickets = 0
    ballers_ball_count = 0
    batsman = 0
    batsman_score = 0


    while balls != 120 or wickets != 10:

        if ballers_ball_count == 6:
            score_card[1][baller] = ballers_wickets
            if baller == 10:
                baller = 0
            else:
                baller += 1
            ballers_ball_count = 0
            ballers_wickets = 0
        if run_score >= tailing_score != 1000:
            break

        User_Ball_Score = int(input("Enter a value between 1 to 6:"))  # value of a single ball
        PC_Bat_Score = random.randint(1, 6)
        # ----------------------Balling score-------------------------
        print("PC batting value", PC_Bat_Score)

        if PC_Bat_Score == User_Ball_Score:
            rand = random.choice(wicket_outputs)
            print(rand)
            score_card[0][batsman] = batsman_score
            PC_Bat_Score = 0
            wickets += 1
            ballers_wickets += 1
            if wickets == 10:
                print("All out")
                break
            else:
                batsman += 1
            batsman_score = 0

        if User_Ball_Score < 1 or User_Ball_Score > 6:
            print("Invalid user input. Please enter another number")
        else:
            run_score += PC_Bat_Score
            batsman_score += PC_Bat_Score

        balls += 1
        ballers_ball_count += 1
        print("Total Score:", run_score, "/", wickets)
        print("Remaining balls:", 120 - balls)

        while True:
            try:
                decision = str(input("Do you want to resume the game:"))
            except ValueError:
                print("Invalid Input")
            except TypeError:
                print("Invalid Input")

            if decision == "yes" or decision == "YES":
                break
            else:
                print("Invalid Input")

        if decision == "no":
            print("Exit the game")
            score_card[1][baller] = ballers_wickets
            score_card[0][batsman] = batsman_score
            break
        else:
            print()
    return run_score, wickets, balls


def printTopPlayers(group, first_inning_data, sec_inning_data, user_team_index, pc_team_index, user_side):
    top_batsmen = []
    top_ballers = []
    top_player_count = 0

    for player_id in range(len(group[pc_team_index])):
        player_array = [first_inning_data[0][player_id],
                        group[user_team_index if user_side == 'batting' else pc_team_index][player_id]]
        top_batsmen.append(player_array)
        player_array = [sec_inning_data[0][player_id],
                        group[pc_team_index if user_side == 'batting' else user_team_index][player_id]]
        top_batsmen.append(player_array)

        player_array = [first_inning_data[1][player_id],
                        group[user_team_index if user_side == 'balling' else pc_team_index][player_id]]
        top_ballers.append(player_array)
        player_array = [sec_inning_data[1][player_id], group[pc_team_index if user_side == 'balling' else user_team_index][player_id]]
        top_ballers.append(player_array)

    top_batsmen.sort(reverse=True)
    top_ballers.sort(reverse=True)


    print("Top batsman of the tournament:")
    while top_player_count!= 5:
        print(f'{top_batsmen[top_player_count][1]}, Score= {top_batsmen[top_player_count][0]}')
        top_player_count += 1

    top_player_count = 0

    print()
    print("Top wicket holders of the tournament:")
    while top_player_count != 5:
        print(f'{top_ballers[top_player_count][1]}, Wickets= {top_ballers[top_player_count][0]}')
        top_player_count += 1