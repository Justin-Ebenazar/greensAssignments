let guess;

function guessFix(){
    const min = Number(document.getElementById("min").value);
    const max = Number(document.getElementById("max").value);
    
    guess = Math.floor(Math.random() * (max - min)) + min;
    const guessy = document.getElementById("Guess-answer");
    guessy.innerHTML = "Your random number is "+guess
}

// function guessCheck(){
//     const userGuess = Number(document.getElementById("myGuess").value);
//     const wish = document.getElementById("wish");
//     const guessButt = document.getElementById("guess");
    
//     if(userGuess === guess){
//         guessy.innerHTML = ("");
//         wish.innerHTML = ("You guessed it right!");
//         userGuess.disabled = false;
//         guessButt.disabled = false;
//     } else if(userGuess < guess){
//         guessy.innerHTML = ("");
//         setTimeout(() => {
//             guessy.innerHTML = ("Too low! Try again.");}, 200);
//         } 
//     else {
//         guessy.innerHTML = ("");
//         setTimeout(() => {
//         guessy.innerHTML = ("Too high! Try again.");}, 200);
//     }   
//     // document.getElementById("myGuess").value = "";
// }