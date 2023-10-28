function reverseWordsInSentence(sentence) {
    
    const words = sentence.split(' ');

    
    const reversedWords = words.map(function(word) {
        return word.split('').reverse().join('');
    });

    
    const reversedSentence = reversedWords.join(' ');

    return reversedSentence;
}


function sortArrayDescending(arr) {
    arr.sort(function(a, b) {
        return b - a;
    });
}


const inputSentence = "This is a sunny day";
const reversedSentence = reverseWordsInSentence(inputSentence);
console.log("Reversed Sentence: " + reversedSentence);

const inputArray = [5, 2, 8, 1, 9];
sortArrayDescending(inputArray);
console.log("Sorted Array in Descending Order: " + inputArray);
