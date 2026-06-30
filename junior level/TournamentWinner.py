"""
Tournament Winner

Given an array of pairs representing the teams in each competition, and an array of results
where 1 means the home team won and 0 means the away team won, determine the overall winner
of the tournament. Each win awards 3 points, and the team with the highest total points wins.

The input is a list of competitions, each a two-element list [homeTeam, awayTeam], and a
parallel list of results (0 or 1) indicating the winner of each competition.

Input: [["HTML", "C#"], ["C#", "Python"], ["Python", "HTML"]], [0, 0, 1]
Output: "Python"

"""

Home_TEAM_WON = 1

# O(n) time | O(k) space
def solution1(competitions, results):
    currentBestTeam = ""
    scores = {currentBestTeam: 0}

    for idx, competition in enumerate(competitions):
        result = results[idx]
        homeTeam, awayTeam = competition

        winningTeam = homeTeam if result == Home_TEAM_WON else awayTeam

        updateScores(winningTeam, 3, scores)

        if scores[winningTeam] > scores[currentBestTeam]:
            currentBestTeam = winningTeam
    
    return currentBestTeam

def updateScores(team, points, scores):
    if team not in scores:
        scores[team] = 0
    else:
        scores[team] += points


print(solution1([["HTML", "C#"], ["C#", "Python"], ["Python", "HTML"]], [0, 0, 1]))