import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        text: "#dfeaec", // Color for text - a light bluish-gray
        background: "#050a0a", // Background color - a dark near-black
        primary: "#9ad1da", // Primary color - a light bluish-turquoise
        secondary: "#267a87", // Secondary color - a darker bluish-turquoise
        accent: "#3bc3d8", // Accent color - a bright bluish-cyan
      },
    },
  },
  plugins: [],
};
export default config;
