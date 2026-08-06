const API_BASE_URL = "https://the-ba-kene-concierge.onrender.com";

export async function getDashboard() {

    const response = await fetch(
        `${API_BASE_URL}/api/admin/dashboard`
    );

    if (!response.ok) {
        throw new Error("Unable to load dashboard");
    }

    return response.json();
}