import { applicants } from '../../src/api/applicants';

test('Get applicants from database and check fields', async () => {
    const applicant = await applicants.get();
    const obj = {
        id: expect.any(Number),
        name: expect.any(String),
        lastName: expect.any(String),
        pnr: expect.any(String),
        email: expect.any(String)
    };

    expect(applicant).toEqual(expect.objectContaining({
        content: expect.arrayContaining([expect.objectContaining(obj)]),
        pageable: expect.objectContaining({
            sort: expect.objectContaining({
                empty: expect.any(Boolean),
                sorted: expect.any(Boolean),
                unsorted: expect.any(Boolean)
            })
        }),
        totalPages: expect.any(Number),
        totalElements: expect.any(Number),
        size: expect.any(Number),
        numberOfElements: expect.any(Number)
    }));
});

test('Get applicants with specified size', async () => {
    const size = 20;
    const page = 0;
    const applicant = await applicants.get(page, size);

    expect(applicant.content.length).toBe(size);
});

test('Get applicants with specified size', async () => {
    const size = 20;
    const page = 0;
    const applicant = await applicants.get(page, size);

    expect(applicant.content.length).toBe(size);
});
test('Send faulty size', async () => {
    const size = 'this should not work';
    const page = 0;
    expect(applicants.get(page, size)).rejects.toThrowError('Bad Request');
});
test('Send faulty page', async () => {
    const size = 10;
    const page = 'this should not work';
    expect(applicants.get(page, size)).rejects.toThrowError('Bad Request');
});
test('Send faulty page and size', async () => {
    const size = 'this should not work';
    const page = 'this should not work';
    expect(applicants.get(page, size)).rejects.toThrowError('Bad Request');
});
