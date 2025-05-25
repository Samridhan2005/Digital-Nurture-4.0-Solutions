// 1. JavaScript Basics & Setup
console.log("Welcome to the Community Portal");
window.addEventListener('load', function() {
    alert('The page is fully loaded!');
});

// 2. Syntax, Data Types, and Operators
const eventName = "Music Night";
const eventDate = "2024-07-15";
let seats = 50;
console.log(`Event: ${eventName} | Date: ${eventDate} | Seats: ${seats}`);

function registerSeat() {
    if (seats > 0) {
        seats--;
        console.log(`Registered! Seats left: ${seats}`);
    } else {
        console.log("No seats available!");
    }
}

// 3. Conditionals, Loops, and Error Handling
const today = new Date();
const events = [
    { name: "Music Night", date: "2024-07-15", seats: 10, category: "music" },
    { name: "Sports Day", date: "2024-06-10", seats: 0, category: "sports" },
    { name: "Art Workshop", date: "2024-08-01", seats: 5, category: "workshop" },
    { name: "Book Fair", date: "2024-05-01", seats: 20, category: "books" }
];
function showUpcomingEvents() {
    events.forEach(ev => {
        const eventDate = new Date(ev.date);
        if (eventDate > today && ev.seats > 0) {
            console.log(`Upcoming: ${ev.name} (${ev.date}) - Seats: ${ev.seats}`);
        }
    });
}
function tryRegister(eventIndex) {
    try {
        if (events[eventIndex].seats > 0) {
            events[eventIndex].seats--;
            console.log(`Registered for ${events[eventIndex].name}`);
        } else {
            throw new Error("No seats available");
        }
    } catch (err) {
        console.error("Registration error:", err.message);
    }
}

// 4. Functions, Scope, Closures, Higher-Order Functions
function addEvent(name, date, seats, category) {
    events.push({ name, date, seats, category });
}
function registerUser(eventName) {
    const ev = events.find(e => e.name === eventName);
    if (ev && ev.seats > 0) {
        ev.seats--;
        return true;
    }
    return false;
}
function filterEventsByCategory(category, callback) {
    const filtered = events.filter(ev => ev.category === category);
    if (callback) callback(filtered);
    return filtered;
}
function registrationCounter() {
    let total = 0;
    return function() {
        total++;
        return total;
    };
}
const musicRegCounter = registrationCounter();

// 5. Objects and Prototypes
function Event(name, date, seats, category) {
    this.name = name;
    this.date = date;
    this.seats = seats;
    this.category = category;
}
Event.prototype.checkAvailability = function() {
    return this.seats > 0;
};
const eventObj = new Event("Charity Run", "2024-09-01", 30, "charity");
console.log(Object.entries(eventObj));

// 6. Arrays and Methods
const allEvents = [
    new Event("Music Night", "2024-07-15", 10, "music"),
    new Event("Sports Day", "2024-06-10", 0, "sports"),
    new Event("Art Workshop", "2024-08-01", 5, "workshop")
];
allEvents.push(new Event("Book Fair", "2024-05-01", 20, "books"));
const musicEvents = allEvents.filter(ev => ev.category === "music");
const eventCards = allEvents.map(ev => `${ev.category.charAt(0).toUpperCase() + ev.category.slice(1)}: ${ev.name}`);
console.log(eventCards);

// 7. DOM Manipulation
function renderEvents() {
    const eventList = document.querySelector('#eventList');
    if (!eventList) return;
    eventList.innerHTML = '';
    allEvents.forEach((ev, idx) => {
        const card = document.createElement('div');
        card.className = 'card mb-2';
        card.innerHTML = `<div class="card-body"><h5>${ev.name}</h5><p>Date: ${ev.date}</p><p>Seats: ${ev.seats}</p><button class="btn btn-primary btn-sm register-btn" data-idx="${idx}">Register</button></div>`;
        eventList.appendChild(card);
    });
    setupEventHandlers(); // Ensure handlers are set after rendering
}
renderEvents();

// 8. Event Handling
function setupEventHandlers() {
    document.querySelectorAll('.register-btn').forEach((btn) => {
        btn.onclick = function() {
            const idx = parseInt(btn.getAttribute('data-idx'));
            tryRegister(idx);
            renderEvents();
        };
    });
    const eventSelect = document.querySelector('select[name="eventSelect"]');
    if (eventSelect) {
        eventSelect.onchange = function() {
            // Optionally filter events or update UI
        };
    }
    const nameInput = document.querySelector('input[name="name"]');
    if (nameInput) {
        nameInput.onkeydown = function(e) {
            if (e.key === 'Enter') {
                // Optionally implement quick search
            }
        };
    }
}
window.addEventListener('DOMContentLoaded', setupEventHandlers);

// 9. Async JS, Promises, Async/Await
function fetchEvents() {
    // Simulate fetch with Promise
    return new Promise((resolve) => {
        setTimeout(() => resolve([...allEvents]), 1000);
    });
}
fetchEvents().then(evts => console.log('Fetched events:', evts)).catch(err => console.error(err));
async function fetchAndShowEvents() {
    const eventList = document.querySelector('#eventList');
    if (eventList) eventList.innerHTML = '<div>Loading...</div>';
    try {
        const evts = await fetchEvents();
        if (eventList) eventList.innerHTML = evts.map(ev => `<div>${ev.name} (${ev.date})</div>`).join('');
    } catch (e) {
        if (eventList) eventList.innerHTML = '<div>Error loading events</div>';
    }
}
// fetchAndShowEvents(); // Uncomment to test async/await rendering

// 10. Modern JavaScript Features
const [firstEvent, ...restEvents] = allEvents;
function showEventDetails({ name, date, seats }) {
    console.log(`Event: ${name}, Date: ${date}, Seats: ${seats}`);
}
showEventDetails(firstEvent);

// 11. Working with Forms
const regForm = document.getElementById('registrationForm');
if (regForm) {
    regForm.addEventListener('submit', function(e) {
        e.preventDefault();
        const { name, email, eventSelect } = regForm.elements;
        if (!name.value || !email.value || !eventSelect.value) {
            document.getElementById('formMessage').textContent = 'All fields required!';
            return;
        }
        document.getElementById('formMessage').textContent = '';
        // Simulate registration
        tryRegister(eventSelect.selectedIndex - 1);
        renderEvents();
        document.getElementById('formMessage').textContent = 'Registered successfully!';
    });
}

// 12. AJAX & Fetch API
function postRegistration(data) {
    document.getElementById('formMessage').textContent = 'Submitting...';
    return new Promise((resolve) => {
        setTimeout(() => resolve({ success: true }), 1200);
    });
}
// Example usage:
// postRegistration({ name: 'Test', email: 'test@mail.com', event: 'Music Night' })
//   .then(res => document.getElementById('formMessage').textContent = res.success ? 'Success!' : 'Failed!');

// 13. Debugging and Testing
// Use console.log, breakpoints, and inspect variables as needed in DevTools

// 14. jQuery and JS Frameworks
// If jQuery is loaded:
// $('#registerBtn').click(function() { alert('Registered!'); });
// $('.card').fadeIn();
// One benefit of React/Vue: Component-based UI for better state management and reactivity.
