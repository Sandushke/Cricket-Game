import random
import Functions

# -----------------ROUND ONE MATCH---------------------------------
Group_A = ("Australia", "England", "South Africa", "India")
Group_B = ("Sri Lanka", "West Indies", "New Zealand", "Pakistan")

# Australia, England, South Africa, India
groupA_players = [
                  ["Luis", "Sebastian", "Jose", "Angel", "Carlos", "Diego", "Gabriel", "Kevin", "Juan", "Adrian", "Williamson"],
                  ["Ryan", "Michael", "Jacob", "Matthew", "William", "John", "Jack", "Nicholas", "Joseph", "Alexander", "Root"],
                  ["Michael", "Matthew", "Anthony", "Daniel", "Ryan", "Joseph", "Jayden", "Christopher", "Jacob", "Alexander", "Butler"],
                  ["Jacob", "Michael", "Ryan", "Joshua", "William", "Christopher", "Ethan", "Jayden", "Andrew", "Anthony", "Finch"]]

# Sri lanka, West Indies, New Zealand, Pakistan
groupB_players = [
                  ["Ethan", "Aiden", "Jacob", "Alexander", "William", "Gabriel", "Jackson", "Michael", "Logan", "Daniel", "Maxwell"],
                  ["Ethan", "Alexander", "Logan", "William", "Jacob", "Benjamin", "Mason", "Noah", "Samuel", "Gavin", "Stokes"],
                  ["Ethan", "Jacob", "William", "Wyatt", "Gabriel", "Logan", "Brayden", "James", "Andrew", "Hunter", "Warner"],
                  ["Michael", "Jacob", "William", "Christopher", "Joshua", "Jayden", "Anthony", "James", "John", "Ryan", "Morgan"]]


#------------Batting and  Balling---------------------------------
score_card_1st_innings = [[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]
score_card_2nd_innings = [[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]


# -----------Print the main menue--------------
Functions.main_menue()


# ------------Select a group either from A or B--------------
selected_group = int(input("Enter your choice:"))


# Choosing the teams
print("-----------------START OF THE GAME-------------------------------")
if selected_group == 1:
    team_pc = random.choice(Group_A)
    team_user = input("Choose your team:").capitalize()

#---------------Making the second word of the team capitalize---------------------
    for i in team_user:
        if i == " ":
            split_words = team_user.split(" ")
            team_user = f'{split_words[0].capitalize()} {split_words[1].capitalize()}'

    while True:
        if team_pc == team_user:
            team_pc = random.choice(Group_A)
        else:
            break
    print("Computer:", team_pc)
    team_pc_index = Group_A.index(team_pc)
    team_user_index = Group_A.index(team_user)


elif selected_group == 2:
    team_pc = random.choice(Group_B)
    team_user = input("Choose your team:").capitalize()

    for i in team_user:
        if i == " ":
            split_words = team_user.split(" ")
            team_user = f'{split_words[0].capitalize()} {split_words[1].capitalize()}'

    while True:
        if team_pc == team_user:
            team_pc = random.choice(Group_A)
        else:
            break
    print("Computer:", team_pc)
    team_pc_index = Group_B.index(team_pc)
    team_user_index = Group_B.index(team_user)


# ---------------Editing the team player names---------------------
edit_players = input("Do you want to do any changes in your team: ").capitalize()
if edit_players == "Yes":
    if selected_group == 1:
        Functions.editPlayer(groupA_players, team_user_index)
    else:
        Functions.editPlayer(groupB_players, team_user_index)
else:
    print("No changes!")


print()
print("***********TIME FOR THE TOSS***************")
# ----------Choosing the toss either Head or Tail--------------------
user_toss_choice = input('Select a side, heads or tails: ')
pc_toss_choice = ''
winning_toss_choice = ['heads', 'tails']
toss_winner = ""

team_user_side = ""
team_pc_side = ""

if user_toss_choice.lower() == 'heads':
    pc_toss_choice = 'tails'
elif user_toss_choice.lower() == 'tails':
    pc_toss_choice = 'heads'

#--------------Choosing whether to bat or ball----------------
if random.choice(winning_toss_choice) == user_toss_choice:
    toss_winner = "user"
    print("You won the toss")
    # -----------Batting side or balling side--------------
    team_user_side = input("Choose either batting or balling:")
    if team_user_side == "batting":
        team_pc_side = "balling"
    elif team_user_side == "balling":
        team_pc_side = "batting"
    else:
        print("Invalid side")
else:
    toss_winner = "pc"
    print("PC won the toss")
    team_pc_side = random.choice(["batting", "balling"])
    if team_pc_side == "batting":
        team_user_side = "balling"
    elif team_pc_side == "balling":
        team_user_side = "batting"
    else:
        print("Invalid side")

print()
#----------- Printing the two teams-----------------
if selected_group == 1:
    Functions.displayGroupTeam(team_pc_index, team_user_index, groupA_players)

elif selected_group == 2:
    Functions.displayGroupTeam(team_pc_index, team_user_index, groupB_players)


print("---------Beginning of 1st Innings--------")
results_innings_1 = []

print()
if toss_winner == "user":
    if team_user_side == "batting":
        results_innings_1 = Functions.battingScenario(score_card_1st_innings)  # Batting Scenario
    else:
        results_innings_1 = Functions.ballingScenario(score_card_1st_innings)  # Balling scenario
else:
    if team_pc_side == "batting":
        results_innings_1 = Functions.ballingScenario(score_card_1st_innings)  # Balling scenario
    else:
        results_innings_1 = Functions.battingScenario(score_card_1st_innings)  # Batting Scenario


# ******END OF THE 1st INNINGS**********
# ******Innings Summary*****************
print("\nFinal Score(Result):")
print("\nRuns:", results_innings_1[0], end="")
print("\tWickets:", results_innings_1[1], end="")
print("\tBalls:", results_innings_1[2])
print()
print("computer needs", results_innings_1[0] + 1, "runs to win from 120 balls")


print("-------------Here starts the 2nd innings-------------")
results_innings_2 = []

if toss_winner == "pc":
    if team_pc_side == "batting":  # Check whether PC ball or bat on 1st innings
        results_innings_2 = Functions.battingScenario(score_card_2nd_innings, results_innings_1[0] + 1)  # if PC Bat on 1st innings here, User Bats.
    else:
        results_innings_2 = Functions.ballingScenario(score_card_2nd_innings, results_innings_1[0] + 1)  # if PC Balled on 1st innings, here User Balls.
else:
    if team_user_side == "balling":  # Check whether User balled or bat on 1st innings
        results_innings_2 = Functions.battingScenario(score_card_2nd_innings, results_innings_1[0] + 1)  # if User Balled on 1st innings, here User Bats.
    else:
        results_innings_2 = Functions.ballingScenario(score_card_2nd_innings, results_innings_1[0] + 1)  # if User Bat on 1st innings, here User Balls.


# ********END OF THE 2nd INNINGS***********
# ********Inning Summary*******************
print("\nFinal Score (Result):")
print("\nRuns:", results_innings_2[0], end="")
print("\tWickets:", results_innings_2[1], end="")
print("\tBalls:", results_innings_2[2])
print()


# ------------Selecting which team won the match (Either PC or User)------------------
if results_innings_1[0] > results_innings_2[0]:
    if team_user_side == "batting":
        print("User Won")
    else:
        print("PC won")
elif results_innings_1[0] < results_innings_2[0]:
    if team_user_side == "batting":
        print("PC won")
    else:
        print("User won")
        print()


if selected_group == 1:
    Functions.printTopPlayers(groupA_players, score_card_1st_innings, score_card_2nd_innings, team_user_index, team_pc_index, team_user_side)
else:
    Functions.printTopPlayers(groupB_players, score_card_1st_innings, score_card_2nd_innings, team_user_index, team_pc_index, team_user_side)


# -------------------File write---------------------
file = open('result.txt', 'a')
file.write(f"\n1st Innings:- \nRuns: {results_innings_1[0]}, \tWickets: {results_innings_1[1]}, \t Balls: {results_innings_1[2]}")
print()
file.write(f"\n2nd Innings:- \nRuns: {results_innings_2[0]}, \tWickets: {results_innings_2[1]}, \t Balls: {results_innings_2[2]}")