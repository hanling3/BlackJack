# Blackjack Game

This is a text-based implementation of the classic casino card game Blackjack in Java. The game provides a simple command-line interface for playing.

## Installation

1. Clone the repository to your local machine using the following command:
git clone https://github.com/hanling3/blackjack.git

2. Navigate to the project directory:
cd blackjack

3. Compile the Java source files:
javac *.java

4. Run the game:
java blackjack

## Game Rules

1. The goal of the game is to beat the dealer's hand without exceeding a total value of 21.

2. The game starts with the player being dealt two cards from a standard deck of 52 cards. The dealer also receives two cards, but only one of them is face-up.

3. The player can choose to "hit" and receive additional cards to improve their hand, or "stand" and keep their current hand.

4. If the player's hand exceeds a total value of 21, they lose the game (bust).

5. Once the player stands, the dealer reveals their face-down card and continues to hit or stand according to predefined rules (usually dealer hits until their hand value is 17 or greater).

6. If the dealer busts, the player wins. If the dealer does not bust, then the hands are compared, and the one with a total value closest to 21 wins. In case of a tie, the game is a push (a draw).

7. The game provides options for restarting or quitting after each round.

## Usage

1. Follow the on-screen prompts to make decisions during the game, such as hitting, standing, restarting, or quitting.

2. Use the keyboard to input your choices when prompted.

## Acknowledgements

This project was inspired by the classic casino game of Blackjack and is for educational purposes only. No real money is involved.
