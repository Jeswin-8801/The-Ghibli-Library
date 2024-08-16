import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
    base: "/",
    plugins: [react()],
    preview: {
        port: 8082,
        strictPort: true,
    },
    server: {
        port: 8082,
        strictPort: true,
        host: true,
    },
})
