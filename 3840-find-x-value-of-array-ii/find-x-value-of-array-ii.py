class Solution:
    def resultArray(self, nums, k, queries):
        n = len(nums)

        # tree[node] = [product_remainder, prefix_counts]
        tree = [[0, [0] * k] for _ in range(4 * n)]

        def build(node, l, r):
            if l == r:
                rem = nums[l] % k
                tree[node][0] = rem
                tree[node][1][rem] = 1
                return

            mid = (l + r) // 2

            build(node * 2, l, mid)
            build(node * 2 + 1, mid + 1, r)

            pull(node)

        def pull(node):
            left = node * 2
            right = node * 2 + 1

            left_product = tree[left][0]
            right_product = tree[right][0]

            # Product of the whole segment
            tree[node][0] = (left_product * right_product) % k

            left_count = tree[left][1]
            right_count = tree[right][1]
            current = tree[node][1]

            for x in range(k):
                current[x] = left_count[x]

            # Prefixes containing the entire left segment
            # and a prefix of the right segment
            for x in range(k):
                if right_count[x]:
                    rem = (left_product * x) % k
                    current[rem] += right_count[x]

        def update(node, l, r, index, value):
            if l == r:
                rem = value % k

                tree[node][0] = rem
                tree[node][1] = [0] * k
                tree[node][1][rem] = 1
                return

            mid = (l + r) // 2

            if index <= mid:
                update(node * 2, l, mid, index, value)
            else:
                update(node * 2 + 1, mid + 1, r, index, value)

            pull(node)

        def merge(a, b):
            # a = (product, prefix_counts)
            # b = (product, prefix_counts)

            product_a, count_a = a
            product_b, count_b = b

            result = [0] * k

            # Prefixes completely inside a
            for x in range(k):
                result[x] += count_a[x]

            # Prefixes containing all of a
            # and a prefix of b
            for x in range(k):
                if count_b[x]:
                    rem = (product_a * x) % k
                    result[rem] += count_b[x]

            product = (product_a * product_b) % k

            return (product, result)

        def query(node, l, r, ql, qr):
            if ql <= l and r <= qr:
                return (
                    tree[node][0],
                    tree[node][1][:]
                )

            mid = (l + r) // 2

            if qr <= mid:
                return query(node * 2, l, mid, ql, qr)

            if ql > mid:
                return query(node * 2 + 1, mid + 1, r, ql, qr)

            left_result = query(node * 2, l, mid, ql, qr)
            right_result = query(node * 2 + 1, mid + 1, r, ql, qr)

            return merge(left_result, right_result)

        build(1, 0, n - 1)

        answer = []

        for index, value, start, x in queries:
            # Update persists for future queries
            update(1, 0, n - 1, index, value)

            # We need all possible prefixes of nums[start:]
            _, prefix_count = query(
                1, 0, n - 1,
                start,
                n - 1
            )

            answer.append(prefix_count[x])

        return answer

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna