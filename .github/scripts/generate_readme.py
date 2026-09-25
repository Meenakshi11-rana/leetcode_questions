import os
import re

REPO_NAME = "leetcode_questions"
GITHUB_USER = "Meenakshi11-rana"

def format_title(folder_name):
    # Splits folder like '1406-subtract-the-product...' into ID and Title
    parts = folder_name.split('-', 1)
    if len(parts) < 2:
        return folder_name, folder_name
    prob_id = parts[0]
    title = parts[1].replace('-', ' ').title()
    return prob_id, title

def get_latest_commit_message(folder_path):
    # Reads commit message if recorded, or parses local README in problem directory
    readme_path = os.path.join(folder_path, "README.md")
    runtime, memory = "—", "—"
    if os.path.exists(readme_path):
        with open(readme_path, "r", encoding="utf-8") as f:
            content = f.read()
            # Try matching LeetSync style metrics if present
            rt_match = re.search(r"Runtime:\s*([^\n|]+)", content)
            mem_match = re.search(r"Memory:\s*([^\n|]+)", content)
            if rt_match:
                runtime = rt_match.group(1).strip()
            if mem_match:
                memory = mem_match.group(1).strip()
    return runtime, memory

def generate_readme():
    folders = [
        d for d in os.listdir('.') 
        if os.path.isdir(d) and not d.startswith('.') and d[0].isdigit()
    ]
    
    # Sort folders numerically by problem ID
    folders.sort(key=lambda x: int(x.split('-')[0]) if x.split('-')[0].isdigit() else 0)

    table_rows = []
    for folder in folders:
        prob_id, title = format_title(folder)
        runtime, memory = get_latest_commit_message(folder)
        row = f"| **{prob_id}** | [{title}](./{folder}) | {runtime} | {memory} |"
        table_rows.append(row)

    table_content = "\n".join(table_rows)

    readme_template = f"""# LeetCode Solutions in Java & Python

Welcome to the **{REPO_NAME}** repository! This repository contains clean, efficient, and well-structured solutions for various LeetCode coding challenges.

## 📌 Features

- **Languages Used:** Java, Python
- **Automated Syncing:** Automatically updates index table via GitHub Actions upon pushing new solutions.
- **Structured Layout:** Each problem is organized into its own directory containing solution code and explanations.

---

## 📂 Submissions & Topic Overview

| Problem # | Title / Topic | Runtime | Memory |
| :--- | :--- | :--- | :--- |
{table_content}

---

## 🛠️ How to Use

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/](https://github.com/){GITHUB_USER}/{REPO_NAME}.git
   cd {REPO_NAME}
